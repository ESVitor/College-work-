<!DOCTYPE html>

<html>
    <head>
        <title> Log out </title>
        
    </head>
    <body>
        
        <div id="page1" data-role="page">

            <?php
           
            
            echo 'Are you sure you whant to log out?';
                    
                include('header.php');
                
                
            ?>
            
  
            <?php
            echo '<a href="index.php"  data-transition="fade" class="ui-btn">Yes</a>';
            
            ?>
            
                  
        <?php
            include('footer.php');
            
           
            
        ?>
    
        
        </div>

    </body>
</html>


