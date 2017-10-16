<!DOCTYPE html>



<html>
    
    <head>
        
        <title> Delivery_ListOfOrders</title>
        
        <?php
            include('header.php');
        ?>
    
    </head>
    
    <style>
        
        tr:nth-child(even) {
        background-color: #dddddd;
        }
        
    </style>
    
    
    <body>
        
        <div id="div1" >
           <h3>List of orders</h3><br>
            <?php
                
                 
                try {

                    include('db.php');


                    $sql = "select * from orders";
                    $sth = $DBH->prepare($sql);

                    $sth->execute();


                    echo '<table>';
                        echo '<tr> <td><b>Order ID</b></td> <td><b>Customer</b></td> <td><b>items</b></td> <td><b>Order date</b></td> <td><b>Status<b></td> </tr>';    

                        while ($row = $sth->fetch(PDO::FETCH_ASSOC)) {


                        $order_id = $row['order_id'];
                        $user_id = $row['user_id'];
                        $items = $row['items'];
                        $order_date = $row['order_date'];
                        $status = $row['status'];
                        
                        
                        echo '<tr>'; 
                            echo '<td>' . $order_id . '</td>'; 
                            echo '<td>' . $user_id . '</td>'; 
                            echo '<td>' . $items . '</td>'; 
                            echo '<td>' . $order_date . '</td>'; 
                            echo '<td>' . $status . '</td>';
                        echo '</tr>';     

                        }
                    echo '</table>';

                } catch(PDOException $e) {echo $e;}
            
            ?>

           
        
        </div>
        <br>
        <a href="delivery.php"  data-transition="fade" class="ui-btn">Return to Delivery page</a>
        
        <?php
            include('footer.php');
        ?>
        
    </body>
</html>