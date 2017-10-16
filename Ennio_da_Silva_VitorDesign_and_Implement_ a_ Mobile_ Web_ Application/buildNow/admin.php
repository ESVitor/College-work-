<!DOCTYPE html>

<html>
    <head>
        <title> Administrator</title>
        
    </head>
    <body>
        
        <div id="page1" data-role="page">

            <?php
                include('header.php');
            ?>
            
  
  
            <a href="admin_listOfUsers.php"  data-transition="fade" class="ui-btn">List of users</a>
            <a href="admin_fName.php"  data-transition="fade" class="ui-btn">Edit first name</a>
            <a href="admin_surname.php"  data-transition="fade" class="ui-btn">Edit surname</a>
            <a href="admin_address.php"  data-transition="fade" class="ui-btn">Edit address</a>
            <a href="admin_telephone.php"  data-transition="fade" class="ui-btn">Edit telephone number</a>
            <a href="admin_Email.php"  data-transition="fade" class="ui-btn">Edit E-mail address</a>
            <a href="admin_password.php"  data-transition="fade" class="ui-btn">Edit password</a>
            <a href="admin_type.php"  data-transition="fade" class="ui-btn">Edit type of user</a>
            <a href="log_out.php"  data-transition="fade" class="ui-btn">Log out</a>   
                  
        <?php
            include('footer.php');
        ?>
    
        
        </div>

    </body>
</html>
