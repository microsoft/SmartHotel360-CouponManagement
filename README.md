# Smart hotel Coupon web application using Spring Boot and MySQL

Smart Hotel Coupon web application using Spring Boot with the following options:

- Spring JPA and MySQL for data persistence
- Thymeleaf template for the rendering.

To build and run the sample from a fresh clone of this repo:

## Configure MySQL

1. Create a database "hotel_coupon" in your MySQL instance. Please make sure that your MySQL version is 5.7.
2. Update the application.properties file in the `src/main/resources` folder with the URL, username and password for your MySQL instance. The table schema for the hotel coupon objects will be created for you in the database.


## Build and run the sample

1. `mvnw spring-boot:run`
2. Open a web browser to http://localhost:8080

As you search and review the guests coupons in the app you can verify the search result in the database through the MySQL console using simple statements like 
`select * from guest`.



## Deploy Azure Components with ARM Template

### GitHub Authorize

1. Generate Token

   - Open <https://github.com/settings/tokens> in your web browser.

   - Sign into your GitHub account where you forked this repository.

   - Click **Generate Token**.

   - Enter a value in the **Token description** text box.

   - Select the following scopes (your selections should match the screenshot below):

     - repo (all) -> repo:status, repo_deployment, public_repo
     - admin:repo_hook -> read:repo_hook

     ![](images/github-new-personal-access-token.png)

   - Click **Generate token**.

   - Copy the token.

2. Add the GitHub Token to Azure in the Azure Resource Explorer

   - Open <https://resources.azure.com/providers/Microsoft.Web/sourcecontrols/GitHub> in your web browser.

   - Log in with your Azure account.

   - Selected the correct Azure subscription.

   - Select **Read/Write** mode.

   - Click **Edit**.

   - Paste the token into the **token parameter**.

     ![](images/update-github-token-in-azure-resource-explorer.png)

   - Click **PUT**.

### Deploy Azure Components

1. Fork this repository to your GitHub account.

2. Click the Deploy to Azure Button:

    [![Deploy to Azure](https://camo.githubusercontent.com/9285dd3998997a0835869065bb15e5d500475034/687474703a2f2f617a7572656465706c6f792e6e65742f6465706c6f79627574746f6e2e706e67)](https://portal.azure.com/#create/Microsoft.Template/uri/https%3A%2F%2Fraw.githubusercontent.com%2FMicrosoft%2FSmartHotel360-CouponManagement%2Fmaster%2Fazuredeploy.json)

3. Fill in the values on the deployment page:

    ![](images/azure-deploy.png)

    **BASICS**:

    * **Subscription**: choose one of you subscriptions.
    * **Resource group**: it is recommend to create a new resource group.
    * **Location**: choose a location.

    **SETTINGS**:

    - **Web App Name**: the name of the web app. It should be unique. It is recommended to use a name like `hotel-coupon-mgmt-<YourName>-<Date>`, for example: `hotel-coupon-mgmt-bob-180129`

    - **MySQL Admin Login Name**: The admin login name of the MySQL server. Keep the default value or use the one you prefer.

      > Note: Please do not use 'azure_superuser', 'admin', 'administrator', 'root', 'guest' or 'public'.

    - **MySQL Admin Login Password**: The admin login password of the MySQL server. Please use a strong password, for example `P@ssw0rd2o18!`.

    - **Source Code Repository**: use the URL of the repository you just created -`https://github.com/<YourAccount>/Huddle`

    - **Source Code Branch**: master

    - **Source code Manual Integration**: false

    **TERMS AND CONDITIONS**:

    - Check **I agree to the terms and conditions stated above**.

4. Click **Purchase**.

5. Visit the created hotel coupon web site at http://**[Web App Name]**.azurewebsites.net/

6. Login with username/password as **me@smarthotel360.com/1234**.
