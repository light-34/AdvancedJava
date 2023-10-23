SELECT 0 as ROWNUM, count(DISTINCT DIST_ACCT) AS TOTAL_STOPS,
       count(DISTINCT DIST_ACCT) - count(DISTINCT TRK.SGTACCTID) AS REMAINING_STOPS,
       count(DISTINCT TRK.SGTACCTID) AS COMPLETE_STOPS,
       sum(case when ROWNR2 = 1 then QTY else 0 end) AS CASES_NUMBER,
       sum(case when ROWNR = 1 and SGTVALUE2 is not null and SGTVALUE2 <> '' then SGTVALUE2 else 0 end) AS CASES_ORDERED,
       sum(case when ROWNR = 1 and SGTVALUE1 is not null and SGTVALUE1 <> '' then SGTVALUE1 else 0 end) AS CASES_DELIVERED,
       sum(case when ROWNR = 1 and SGTVALUE2 is not null and SGTVALUE2 <> '' then SGTVALUE2 else 0 end) + 0 - sum(case when ROWNR = 1 and SGTVALUE1 is not null and SGTVALUE1 <> '' then SGTVALUE1 else 0 end) AS CASES_RETURNED,
       sum(case when ROWNR2 = 1 then QTY else 0 end) - sum(case when ROWNR = 1 and SGTVALUE1 is not null and SGTVALUE1 <> '' then SGTVALUE1 else 0 end) AS CASES_REMAINING,
       TRK.DIST AS TRK_DIST, TRK.DDBA AS TRK_DDBA, TRK.LOAD AS TRK_LOAD
from ( select SVA.SVAVPID, SVA.SVAACCTID, SVA.SVAACCT ACCOUNT_CODE, SVASMNAME SALESMAN_NAME, SVASMID SALESMAN_NBR, SVA.SVAACCT, SVA.SVADBA, SVA.SVAADDR,
              SVA.SVACITY, SVA.SVASTATE, SVA.SVAZIP5, SVA.SVALONG, SVA.SVALAT, SVA.SVAPREMISE, SVA.SVACOTID, SVA.SVACOTDSC, SVA.SVASCOTID, SVA.SVASCOTDSC,
              SVA.SVAVPCHNID, SVA.SVAVPCHNM, SVA.SVACHNSTS, SVA.SVAWHSEID, SVA.SVAWHSEDSC, SVA.SVACOMPID, SVA.SVACOMPDSC, SVA.SVASUPRID, SVA.SVASUPRDSC, SVA.SVAACTPTYP,
              SVA.SVASVCDIST, SGT.SGTACCTID, SGT.SGTVALUE1, SGT.SGTVALUE2, SGT.SGTVALUE3, SGT.SGTVALUE4, SGT.SGTVALUE5, DD.DIST, DD.DDBA, SO.DIST_ACCT, SO.QTY, SO.DATE,
              SO.LOAD, RTE.RTSEQ, ROW_NUMBER() over (PARTITION BY SO.LOAD, SO.SVAACCTID, SO.DATE, SGTTRKTIM) as ROWNR, ROW_NUMBER() over (PARTITION BY SO.DAIDENTITY) as ROWNR2
       from WCS99938.FCTSALES_ORDERS SO
           join WCS99938.DIMDIST DD on (SO.DIST = DD.DIST)
           left join WCS99938.SVYDSRMAS RTE on (RTE.DRVID = SO.DRVID and RTE.SVAACCT = SO.DIST_ACCT and RTE.TDATE = SO.TDATE)
           left join WCS99938.SVGPSTRKT SGT on (SO.SVAACCTID = SGT.SGTACCTID and SGT.SGTVALUE5 = SO.LOAD and SGT.SGTEVENT = 'delinvoice' and SO.DATE = to_char(SGT.SGTTRKTIM, 'YYYYMMDD'))
           left join WCS99938.SVACCTT SVA on (SO.SVAACCTID = SVA.SVAACCTID) ) TRK
where 1=1  and DATE >= ? and DATE <= ?  group by TRK.DIST, TRK.DDBA, TRK.LOAD ORDER BY TRK.DDBA ASC, TRK.LOAD ASC FOR FETCH ONLY



SELECT 0 as ROWNUM, count(distinct SVA.SVAACCTID) AS TOTAL_ACCOUNTS,
       count(distinct case when SGT.SGTEVENT = 'closeaccou' then SGT.SGTACCTID else null end) AS COMPLETE_ACCOUNTS,
       count(distinct SGT.SGTACCTID) AS ACTIVITY_ACCOUNTS, count(distinct SVA.SVAACCTID) - count(distinct case when SGT.SGTEVENT = 'closeaccou' then SGT.SGTACCTID else null end) AS REMAINING_ACCOUNTS,
       RTE.MERCH_CODE AS RTE_MERCH_CODE, SDM.MERCHDSC AS SDM_MERCHDSC
from (select SMM.SVAACCTID  ACCOUNT_ID,
             SMM.MERCHID    MERCH_CODE,
             0              EMPLOYEE_ID,
             SMM.DATE       DATE, SMM.RTSEQ      SEQUENCE, 1              ROUTE_TYPE
      from SR_XXX.SVYMERMAS SMM  where DATE >= ? and DATE <= ?
                                 union select RTD.RTDACCTID      ACCOUNT_ID,
                                           EMT.SALESMAN_NUM   MERCH_CODE, EMT.EMUID          EMPLOYEE_ID, RTH.RTHDATE        DATE,
                                           RTD.RTDSEQ         SEQUENCE, 2                  ROUTE_TYPE
                                       from SR_XXX.SVRTHDRT RTH
                                       join SR_XXX.SVRTDTLT RTD on (RTH.RTHHDRID = RTD.RTDHDRID)
                                           join FR_SRS.EMPMASTT EMT on (EMT.EMUID = RTH.RTHOWNER and EMT.SALESMAN_NUM <> '')
                                                                where RTHDATE >= ? and RTHDATE <= ? ) RTE
    join SR_XXX.SDIMMERCH SDM on (SDM.MERCHID = RTE.MERCH_CODE)
    left join SR_XXX.SVGPSTRKT SGT on (RTE.ACCOUNT_ID = SGT.SGTACCTID and RTE.DATE = to_char(SGT.SGTTRKTIM, 'YYYYMMDD') and SGT.SGTVALUE6 = RTE.MERCH_CODE)
    join SR_XXX.SVACCTT SVA on (RTE.ACCOUNT_ID = SVA.SVAACCTID)
where 1=1  group by RTE.MERCH_CODE, SDM.MERCHDSC ORDER BY SDM.MERCHDSC ASC FOR FETCH ONLY