<!DOCTYPE html>

<html>
    <head>
        <title> View Cart </title>
        
    <?php
            
                include('header.php');
                
                
            ?>
    
    
    </head>
    
     <style>
        
        tr {
        background-color: #dddddd;
        height: 30px;
        
        }
        
        #td1{width: 50px;}
        #td2{width: 100px;}
        #td3{width: 250px;}
        #td4{width: 150px;}
        
               
    </style>
    
    
    
    <body>
        
        <div id="page1" data-role="page">

            
            
            <?php
            
            session_cache_limiter('private');
            $cache_limiter = session_cache_limiter();
            
            session_cache_expire(30);
            $cache_expire = session_cache_expire();
            
            session_start();
            $user_id  = $_GET['user_id'];
                
                echo "The cached session pages will expire after $cache_expire minutes";    
                
                
                echo '<table>';
                        echo '<tr> <td id="td1"> <b>ID</b></td>   <td id="td2">Product</td> <td id="td3">Description</td> <td id="td4">Price</td></tr>';
                echo '</table>';
                
                function getItemsInfo ($items){
                    
                     try { include('db.php');
                    $sql = "select * from products where product_id = $items";
                        
                        $sth = $DBH->prepare($sql); $sth->execute();
        

                    echo '<table>';
                            
         
                        while ($row = $sth->fetch(PDO::FETCH_ASSOC)) {
         
         
                            $id = $row['product_id'];
                            $title = $row['name'];
                            $desc = $row['description'];
                            $price = $row['price'];

                            echo '<tr>'; 
                            echo '<td id="td1">' . $id . '</td>'; 
                            echo '<td id="td2">' . $title . '</td>'; 
                            echo '<td id="td3">' . $desc . '</td>'; 
                            echo '<td id="td4"> Euros: '. $price . '</td>'; 
                            
                            echo '</tr>';     
         
                        }
        
                    echo '</table>';

                } catch(PDOException $e) {echo $e;}
                    
                }
                
                
                
                $items = $_SESSION['cart'];
                $tok = explode(" ", $items);
                
                foreach($tok as $items){
                    
                    getItemsInfo($items);
                }
                
  
            ?>
            
            
            
            <?php
              echo  '<a href="check_out.php?user_id='.$user_id.'"  data-transition="fade" class="ui-btn">Check out order</a>';
              echo  '<a href="customer.php?user_id='.$user_id.'"  data-transition="fade" class="ui-btn">Return to customer</a>';
            ?>
            
                  
        <?php
            include('footer.php');
            
        ?>
    
        
        </div>

    </body>
</html>