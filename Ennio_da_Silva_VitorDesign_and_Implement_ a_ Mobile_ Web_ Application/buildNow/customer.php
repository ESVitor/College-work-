<!DOCTYPE html>

<html>
    <head>
        <title> Customer </title>
        
    </head>
    <body>
        
        <div id="page1" data-role="page">

            <?php
            
                    
                include('header.php');
                
                
            ?>
           
             <?php
                session_start();
                $user_id  = $_GET['user_id'];

            ?>
  
  <?php
            echo '<a href="view_products.php?user_id='.$user_id.'"  data-transition="fade" class="ui-btn">View list of products</a>';
            echo '<a href="view_cart.php?user_id='.$user_id.'"  data-transition="fade" class="ui-btn">View products in the cart</a>';
            echo '<a href="check_out.php?user_id='.$user_id.'"  data-transition="fade" class="ui-btn">Check out</a>';
            echo '<a href="view_products_auto_complite_textbox.php?user_id='.$user_id.'"  data-transition="fade" class="ui-btn"> View products in auto complite text box</a>';
            echo '<a href="log_out.php?user_id='.$user_id.'"  data-transition="fade" class="ui-btn">Log out</a>';
   ?>         
                  
        <?php
            include('footer.php');
       
        ?>
    
        
        </div>

    </body>
</html>
