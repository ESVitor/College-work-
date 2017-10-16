<!DOCTYPE html>

<html>
    <head>
        <title> Check out </title>
        
    </head>
    <body>
        
        <div id="page1" data-role="page">

            <?php
            
               include('header.php');
            
            ?>
            
            <?php
            
                session_start();
                $user_id  = $_GET['user_id'];
                $items = $_SESSION['cart'];
                
                

                echo session_id();
                echo 'items:'.$items;
                
                try{
                    
                    include('db.php');
                    
                    $sql="INSERT INTO `buildnow`.`orders`(`user_id`, `items`) VALUES ($user_id, '$items');";
                    $sth = $DBH->prepare($sql);
                    $sth->execute();
                } catch (PDOException $e) {echo $e;}
                
                echo 'The order is placed';
                
            ?>
  
           <?php
            echo '<a href="customer.php?user_id='.$user_id.'"  data-transition="fade" class="ui-btn">Return to customer</a>';
           ?> 
            
                  
        <?php
            include('footer.php');
           
        ?>
    
        
        </div>

    </body>
</html>