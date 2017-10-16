<!DOCTYPE html>



<html>
    
    <head>
        
        <title> Delivery_SetOrderStatus</title>
        
        <?php
            include('header.php');
        ?>
    
    </head>
    
   
    <body>
        
       <div id="div4" >
        
            <?php
            
                if($_POST){
                    
                    $order_id = $_POST['text-5'];
                    $status = $_POST['text-6'];
                
                    try {

                        include('db.php');

                        
                        $sql = "UPDATE orders SET status = ? WHERE order_id= ?";
                        $sth = $DBH->prepare($sql);

                        
                        $sth->bindParam(1,$status, PDO::PARAM_INT);
                        $sth->bindParam(2,$order_id, PDO::PARAM_INT);

                        $sth->execute();
  
                    } catch(PDOException $e) {echo $e;}
                
                echo '<h3 style="color:red">The order`s status is updated</h3><br>';    
                }
            ?>
            <br>
            <h3>Edit order's status</h3>
            
            <form action="delivery_SetOrderStatus.php" method="post">
            
               Order ID:<input type="text" name="text-5" id="text-5"/>
               Status(shipped):<input type="text" name="text-6" id="text-6"/>
               <button type="submit" class="ui-btn ui-corner-all">update! </button>
            
            </form>
        
        </div>
        
        <a href="delivery.php"  data-transition="fade" class="ui-btn">Return to administrator page</a>
        
        <?php
            include('footer.php');
        ?>
        
    </body>
</html>