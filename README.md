# SpringCloud_GCP_Cloud-SQL-DB

#Google Cloud Configuration for the project

## 1. You can utlize the free Google cloud tire or you can your gcloud to get access.

   ![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/tree/main/img/New Project.JPG)
## 2. Once you active your account you can create new project or use existing project.

## 3. you need to create SQL instance.
   > you can use search bar or menu to find the SQL
## 4. It might take while to configure the instance.

## 5. we need to enable API access for your account.
   > you can search the API using Platform search bar **Cloud SQL Admin API**. you have enable this API service to access the DATABASE.
    
![](https://github.com/sada498/SpringCloud-GCP-Cloud-SQL-DB/blob/main/img/API.JPG)
## 6. Last we need to create  server account to access the services with secure and authenticate credentials by Creating **Service Account** for SQL admin access. 
   > IAM & Admin > service Accounts > 
    >Create Service Account
    > assign access permission as SQL admin
    > create a key
    >Json ( we need to add the path of the location to Project application.properties file)

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
   > Once the application running without problems.You send **Post** request by using postman.
## Postman 

## After sending the Post request you can check the Database table in by using Gcloud shell.
   > SQL > Click on your instance > connect using cloud shell 

     gcloud sql connect sada-postgresql-instance --user=postgres --quiet
   > Enter your password
   > To access the postgres db 

      \c postgres
   > Enter your password 
   > To see the list of tables in DB.

       \dt
   > Check the data added to table or not

    select * from product;
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
 > Done :)
    

    
