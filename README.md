# SpringCloud_GCP_Cloud-SQL-DB

# Google Cloud Configuration for the project

## 1. You can utilize the Google cloud free tier or you can use your gcloud to get access.
  [Google cloud free tier](https://cloud.google.com/free)
## 2. Once you active your account you can create new project or use existing project.
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/New%20Project.JPG)

## 3. you need to create SQL instance.
  > **you can use search bar or menu to find the SQL**
## 4. It might take while to configure the instance.
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/instance.JPG)
## 5. we need to enable API access for your account.
### 5.1 **you can search the API using Platform search bar **Cloud SQL Admin API**. you have enable this API service to access the DATABASE.**
    
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/API.JPG)
## 6. Last we need to create  server account to access the services with secure and authenticate credentials by Creating **Service Account** for SQL admin access. 
###  6.1 **IAM & Admin > service Accounts >** 
###  6.2 **Create Service Account**
    
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/service%20account.JPG)
###  6.3 **assign access permission as SQL admin**
    
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/access%20permision.JPG)
###  6.4 **create a key**
    
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/key.JPG)
###  6.5 **Json ( we need to add the path of the location to Project application.properties file)**
    
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/json.JPG)

# Application configuration to access the Gcloud
    #Project name in Gcloud
    spring.cloud.gcp.project-id=springcloud-data-sql
    # SQL instance connection name 
    spring.cloud.gcp.sql.instance-connection-name=springcloud-data-sql:australia-southeast1:sada-postgresql-instance 
    #Databae name
    spring.cloud.gcp.sql.database-name=postgres
    
    spring.datasource.username=postgres
    #password
    spring.datasource.password=sada
    #Json credentials to access the gloud account.
    spring.cloud.gcp.credentials.location=file:/Users/X270/Desktop/springcloud-data-sql-95f7ceb8e5ec.json
    spring.jpa.generate-ddl=true
  > once you configure the all the details in application.properties file.
## Start the application 
    mvn spring-boot:run 

## Once the application running without problems.You send **Post** request by using Postman 
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/postman.JPG)
## After sending the Post request you can check the Database table in by using Gcloud shell.
### **SQL > Click on your instance > connect using cloud shell**

     gcloud sql connect sada-postgresql-instance --user=postgres --quiet
### **Enter your password**
### **To access the postgres db** 

      \c postgres
### **Enter your password **
   
### **To see the list of tables in DB.**

       \dt
### **Check the data added to table or not**

    select * from product;
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/Gcloud%20Table%20check.JPG)
# OR you can write simple test case to get the data from Gcloud DB table.
    @Test
    	public void testProduct(){
    		List<Product> a=productRepository.findAll();
    		for(Product product : a){
    			//System.out.println(product.getId());
    			System.out.println("Tesla Model: "+ product.getName());
    			System.out.println("Tesla Price: "+ product.getPrice());
    			System.out.println("Warehouse:   "+   product.getWarehouse());
    			System.out.println("-------------------------------------");
    		} 
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/test%20result.JPG)
### **Done :)**
    

    
