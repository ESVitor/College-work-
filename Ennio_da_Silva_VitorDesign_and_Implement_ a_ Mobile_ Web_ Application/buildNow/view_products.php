<!DOCTYPE html>

<html>
    <head>
        <title> View Products </title>
        
    </head>
    <body>
        
        <div id="page1" data-role="page">

            <?php
            
                include('header.php');
                 
            ?>
            
            <?php

                session_start();
                    $user_id  = $_GET['user_id'];
                    echo session_id();
// DB
                try {
                    
                    include('db.php');


                    $sql = "select * from products";
                        
                        $sth = $DBH->prepare($sql);
        
                            $sth->execute();
        

                    echo '<table>';
                        echo '<tr> <td> <b>ID</b></td>   <td>Product</td> <td>Description</td> <td>Price</td></tr>';    
         
                        while ($row = $sth->fetch(PDO::FETCH_ASSOC)) {
         
         
                            $id = $row['product_id'];
                            $title = $row['name'];
                            $desc = $row['description'];
                            $price = $row['price'];

                            echo '<tr>'; 
                            echo '<td>' . $id . '</td>'; 
                            echo '<td>' . $title . '</td>'; 
                            echo '<td>' . $desc . '</td>'; 
                            echo '<td>' . $price . '</td>'; 
                            echo '<td> <a href="add_to_cart.php?id='.$id.'"> Buy!</a> </td>';

                            echo '</tr>';     
         
                        }
        
                    echo '</table>';

                } catch(PDOException $e) {echo $e;}  

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