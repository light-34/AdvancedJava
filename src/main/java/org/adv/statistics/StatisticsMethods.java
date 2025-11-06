package org.adv.statistics;

import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.fraction.FractionFormat;
import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class StatisticsMethods {

    public static void getFraction(Fraction fr, Fraction fr2) {
        Fraction sum = fr.add(fr2);
        System.out.println(new FractionFormat().format(sum));

    }

    public static void getVectorIntersection() {
        Line l1 = new Line(new Vector2D(0,0), new Vector2D(1, 1), 0);
        Line l2 = new Line(new Vector2D(0, 1), new Vector2D(1, 1.5), 0);
        Vector2D intersection = l1.intersection(l2);
        System.out.println("Intersection is : " + intersection.toString() );
    }


    //TODO:  https://www.baeldung.com/apache-commons-math

}
