/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentassingment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class DatabaseUtility {
    private static Connection dbConnection = null;
    static{
        if(dbConnection == null){
        try{  
            System.out.println("Hello World");
            Class.forName("com.mysql.jdbc.Driver");  
            dbConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassessment","root1","root123");  
            System.out.println("Connection OHk");
        }catch(Exception e){
            System.out.println(e);}  
        }  
       }
        
    
        public int update(String query,Object[] queryParam){
            PreparedStatement updateQuery = null;
        try {
            updateQuery = dbConnection.prepareStatement(query);
            setQueryParam(updateQuery, queryParam);
           return updateQuery.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtility.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.getMessage());
            if(updateQuery != null)
                System.out.println("Query:" + updateQuery.toString());
        }
        
        return 0;
        }
     
        public int insert(String query,Object[] queryParam){
             PreparedStatement insertQuery = null;
            try {
                insertQuery = dbConnection.prepareStatement(query);
                insertQuery = setQueryParam(insertQuery, queryParam);
               return insertQuery.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseUtility.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: " + ex.getMessage());
                if(insertQuery != null)
                    System.out.println("Query:" + insertQuery.toString());
            }
        
        return 0;
        }
        
        public int delete(String query,Object[] queryParam){
            PreparedStatement deleteQuery = null;
            try {
                deleteQuery = dbConnection.prepareStatement(query);
                setQueryParam(deleteQuery, queryParam);
               return deleteQuery.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseUtility.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error:" + ex.getMessage());
                if(deleteQuery != null)
                    System.out.println("Query:" + deleteQuery.toString());
            }
            
            return 0;
        }
        
        
        public List select(String query,Object[] queryParam){
            List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
            PreparedStatement selectQuery = null;
            ResultSet resultSet = null;
            try{
                selectQuery = dbConnection.prepareStatement(query);
                selectQuery= setQueryParam(selectQuery, queryParam);
                resultSet = selectQuery.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();
                while(resultSet.next()){
                    Map<String,Object> row = new HashMap<String,Object>();
                    for(int i=1;i<=metaData.getColumnCount();i++){
                        row.put(metaData.getColumnLabel(i), resultSet.getObject(i));
                    }
                    
                    result.add(row);
                }
                
                
                
            }catch(Exception ee){
                System.out.println("Error:" + ee.getMessage());
                if(selectQuery != null)
                    System.out.println("Query:" + selectQuery.toString());
            }finally{
                if(resultSet != null){
                    try {
                        resultSet.close();
                    } catch (SQLException ex) {
                        System.out.println("Error:" + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }
            
            return result;
        }
        
        
        private PreparedStatement setQueryParam(PreparedStatement statement,Object[] paramObj){
           
            if(paramObj == null)
                return statement;
            
            int paramIndex = 1;
            
            try{
                
                for(Object obj : paramObj){

                    if(obj instanceof String)
                        statement.setString(paramIndex, String.valueOf(obj));
                    else if(obj instanceof Integer)
                        statement.setInt(paramIndex, Integer.parseInt(String.valueOf(obj)));
                    else if(obj instanceof Long)
                        statement.setLong(paramIndex, Long.parseLong(String.valueOf(obj)));
                    else if(obj instanceof Float)
                        statement.setFloat(paramIndex, Float.parseFloat(String.valueOf(obj)));
                    else if(obj instanceof Double)
                        statement.setLong(paramIndex, Long.valueOf(String.valueOf(obj)));
                    else if(obj instanceof Timestamp)
                        statement.setTimestamp(paramIndex, Timestamp.valueOf(String.valueOf(obj)));
                    else if(obj instanceof Boolean)
                        statement.setBoolean(paramIndex,Boolean.getBoolean(String.valueOf(obj)));

                    paramIndex++;
                }
            }catch(Exception ee){
            System.out.println("Error:" + ee.getMessage());
            if(statement != null)
                System.out.println("Query:" + statement.toString());
            }
            return statement;
        }
        
//        public static void main(String[] args) {
//            
//            try{  
//            System.out.println("Hello World");
//            Class.forName("com.mysql.jdbc.Driver");  
//            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentassessment","root","root");  
//            System.out.println("Connection OHk");
//        }catch(Exception e){
//            System.out.println(e);}  
//        }
        
        public void closeConnecction(){
            if(dbConnection != null){
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
        


