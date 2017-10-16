<!DOCTYPE html>

<html>
    <head>
        <title> Delivery </title>
        
    </head>
    <body>
        
        <div id="page1" data-role="page">

            <?php
                include('header.php');
            ?>
            
  
  
            <a href="delivery_ListOfOrders.php"  data-transition="fade" class="ui-btn">View list of orders</a>
            <a href="delivery_packingSlips.php"  data-transition="fade" class="ui-btn">Generate pack slips</a>
            <a href="delivery_SetOrderStatus.php"  data-transition="fade" class="ui-btn">Set order status</a>
            <a href="log_out.php"  data-transition="fade" class="ui-btn">Log out</a> 
                  
        <?php
            include('footer.php');
        ?>
    
        
        </div>

    </body>
</html>