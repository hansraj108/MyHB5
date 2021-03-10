package com.hans.capp.controller;

public class FileUploadInDb extends BaseDAO{

	 // This Method Is Used To Save The Uploaded File In The Database
    public void fileSaveInDb(FileUpload fileUploadObj) {
 
       
            String sqlInsertQuery = "INSERT INTO files_upload (file_name, file_description, file_data) VALUES (?, ?, ?)";
            int insertCount = getJdbcTemplate().update(sqlInsertQuery, fileUploadObj.getFileName(), fileUploadObj.getFileDescription(), fileUploadObj.getData());
            if(insertCount == 1) {
                System.out.println("The Uploaded File Is Successfully Saved In The Database...!" + "\n");
            } else {
                System.out.println("Error Occured While Saving The Uploaded File In The Database... Please Check...!" + "\n");
            }
        } 
}
