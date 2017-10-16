<!DOCTYPE html>



<html>
    
    <head>
        
        <title> Staff_ViewListAllProducts </title>
        
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
           <h3>List of products</h3><br>
            <?php
                
                 
                try {

                    include('db.php');


                    $sql = "select * FROM products";
                    $sth = $DBH->prepare($sql);

                    $sth->execute();


                    echo '<table>';
                        echo '<tr> <td><b>Product ID</b></td> <td><b>Name</b></td> <td><b>Description</b></td> <td><b>Price</b></td> </tr>';    

                        while ($row = $sth->fetch(PDO::FETCH_ASSOC)) {


                        $id = $row['product_id'];
                        $name = $row['name'];
                        $description = $row['description'];
                        $price = $row['price'];
                                                
                        echo '<tr>'; 
                            echo '<td>' . $id . '</td>'; 
                            echo '<td>' . $name . '</td>'; 
                            echo '<td>' . $description . '</td>'; 
                            echo '<td>' . $price . '</td>'; 
                            
                        echo '</tr>';     

                        }
                    echo '</table>';

                } catch(PDOException $e) {echo $e;}
            
            ?>
        </div>
        
        <br>
        <a href="staff.php"  data-transition="fade" class="ui-btn">Return to staff page</a>
        
        <?php
            include('footer.php');
        ?>
        
    </body>
</html>