<!DOCTYPE html>

<html>
    <head>
        <title> Welcome page</title>
        
    </head>
    <body>
        
        <div id="page1" data-role="page">

            <?php
                include('header.php');
            ?>
            
  
  
            <a href="login.php"  data-transition="fade" class="ui-btn">Login</a>
            <a href="register.php"  data-transition="flip" class="ui-btn">Register</a>
       
        <?php
            include('footer.php');
        ?>
    
        
        </div>

    </body>
</html>