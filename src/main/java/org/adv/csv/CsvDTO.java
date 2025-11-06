package org.adv.csv;

public class CsvDTO {
    private String fileGuId; //for file api
    private String fileDriveId; //for drive
    private String fileName;
    private String fileStatus;
    private String fileExtension;

    public CsvDTO(String fileGuId, String fileDriveId, String fileName, String fileStatus, String fileExtension) {
        this.fileGuId = fileGuId;
        this.fileDriveId = fileDriveId;
        this.fileName = fileName;
        this.fileStatus = fileStatus;
        this.fileExtension = fileExtension;
    }

    public CsvDTO(String fileDriveId, String fileName, String fileStatus, String fileExtension) {
        this.fileDriveId = fileDriveId;
        this.fileName = fileName;
        this.fileStatus = fileStatus;
        this.fileExtension = fileExtension;
    }

    public String getFileGuId() {
        return fileGuId;
    }

    public void setFileGuId(String fileGuId) {
        this.fileGuId = fileGuId;
    }

    public String getFileDriveId() {
        return fileDriveId;
    }

    public void setFileDriveId(String fileDriveId) {
        this.fileDriveId = fileDriveId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}
