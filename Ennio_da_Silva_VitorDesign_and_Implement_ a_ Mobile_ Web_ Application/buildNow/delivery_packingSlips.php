<!DOCTYPE html>



<html>
    
    <head>
        
        <title> Delivery_PackingSlips</title>
        
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
           
            <h3>Pack slip</h3><br>
            
               <?php
                    if($_POST){
                        
                      
                      echo '<script>window.location = "delivery_PDF.php?id='.$_POST['text-1'].'"</script>';
                    }
               ?>
            
            <form action="delivery_packingSlips.php" method="post">
            
               user ID:<input type="text" name="text-1" id="text-1"/>
               
               <button type="submit" class="ui-btn ui-corner-all">update! </button>
            
            </form>
           
        
        </div>
        <br>
        
        
        
        <a href="delivery.php"  data-transition="fade" class="ui-btn">Return to Delivery page</a>
        
        <?php
            include('footer.php');
        ?>
        
    </body>
</html>