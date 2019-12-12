# WebServiceTest7210

POC application to get the user count from the Portal:

There was an existing application for an older Portal version, and I had to make some changes to it in the code in order to make the POC work:
- in the POC project itself (inside the WebServiceTest7210 application), I had to add these dependencies to the build.gradle file:
compile 'javax.xml.rpc:javax.xml.rpc-api:1.1.1'
compile group: 'org.apache.axis', name: 'axis', version: '1.4'

- next, I had to create a separate user called:  test1  and I had to add the following role to him:
Analytics Administrator

- next, I had to make this change in the UserServiceSoapServiceLocator class:
from:
    private java.lang.String Portal_UserService_address = "http://localhost:8080/api/axis/Portal_UserService";
to:
    private java.lang.String Portal_UserService_address = "http://test1%40liferay.com:test@localhost:8080/api/axis/Portal_UserService";

Once these changes were applied, the application started to show the count of the portal users.
