<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Autocomplete - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  
  
  
  <?php

        session_start();
        $user_id  = $_GET['user_id'];
        echo session_id();

        try {
                    
            include('db.php');


            $sql = "select * from products";
                       
            $sth = $DBH->prepare($sql);
        
            $sth->execute();
        

            echo '<table>';
            echo '<tr> <td> <b>ID</b></td>   <td>Product</td> <td>Description</td> <td>Price</td></tr>';    
                        
                       
            $index = 0;
            
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


                $index++;
                echo '<br/>';
                
                
                    if($index == 1){$in1 = $title.' === Description: '.$desc.' === Price: '.$price;}
                    if($index == 2){$in2 = $title.' === Description: '.$desc.' === Price: '.$price;}
                    if($index == 3){$in3 = $title.' === Description: '.$desc.' === Price: '.$price;}
                    if($index == 4){$in4 = $title.' === Description: '.$desc.' === Price: '.$price;}
                    if($index == 5){$in5 = $title.' === Description: '.$desc.' === Price: '.$price;}
            }
                        
        
            echo '</table>';

            } catch(PDOException $e) {echo $e;}  
            
            

    ?>

<br/>
<br/>
<br/>
  
 <script>
    $( function() {
    var availableTags = [
                            " <?php echo $in1 ?> ",
                            " <?php echo $in2 ?> ",
                            " <?php echo $in3 ?> ",
                            " <?php echo $in4 ?> ",
                            " <?php echo $in5 ?> "
    ];
    
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  } );
  </script>

</head>

<body>
 
    <div class="ui-widget">
      <label for="tags">Search for products: </label>
      <input id="tags">
    </div>

<br/>
<br/>
<br/>
    
     <?php
     
   
     echo '<a href="customer.php?user_id='.$user_id.'"  data-transition="fade" class="ui-btn">Return to customer</a>';
           
     
     ?>
  
</body>


</html>