<!DOCTYPE html>
<html>
    <head>
        <title> Staff_AddNewProduct</title>
        
        <?php
            include('header.php');
        ?>
        
        
        
    </head>
    <body>
            <?php
                include('db.php');
            ?>
            <?php
        
            if($_POST){
               $product_id = $_POST['text-1'];
               $name = $_POST['text-2'];
               $description = $_POST['text-3'];
               $price = $_POST['text-4'];
               
    
                
               
               
               try { 

                    


                    $sql = "INSERT INTO `products` (`product_id`, `name`, `description`, `price`) VALUES (?, ?, ?, ?);";
                    $sth = $DBH->prepare($sql);

                    $sth->bindParam(1, $product_id, PDO::PARAM_INT);
                    $sth->bindParam(2, $name, PDO::PARAM_INT);
                    $sth->bindParam(3, $description, PDO::PARAM_INT);
                    $sth->bindParam(4, $price, PDO::PARAM_INT);
                   

                    $sth->execute();

                   echo '<h3 style="color:red">The product is now registered</h3><br>';

                } catch(PDOException $e) {echo 'Error' . $e;} 

            }


        ?>

        <form  action="staff_addNewProduct.php" method="post">
            
                  Product ID:<input type="text" name="text-1"/>

                  Name:<input type="text" name="text-2" />

                  description:<input type="text" name="text-3"/>

                  Price:<input type="text" name="text-4" />

            
            <button type="submit" class="ui-btn ui-corner-all">Register! </button>
                    
     
            </form>  
            
            <br>  
        
            <a href="staff.php"  data-transition="flip" class="ui-btn">Return to Staff page</a>

        <?php
            include('footer.php');
        ?>
        
        
    </body>
</html>