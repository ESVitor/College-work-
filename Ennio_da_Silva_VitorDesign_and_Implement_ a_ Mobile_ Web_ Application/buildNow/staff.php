<!DOCTYPE html>

<html>
    <head>
        <title> Staff </title>
        
    </head>
    <body>
        
        <div id="page1" data-role="page">

            <?php
                include('header.php');
            ?>
            
  
  
            <a href="staff_addNewProduct.php"  data-transition="fade" class="ui-btn">Add new product</a>
            <a href="staff_ViewListAllProducts.php"  data-transition="fade" class="ui-btn">View list of all products</a>
            <a href="staff_modifyProductInformation.php"  data-transition="fade" class="ui-btn">Modify product information</a>
            <a href="log_out.php"  data-transition="fade" class="ui-btn">Log out</a> 
            
                  
        <?php
            include('footer.php');
        ?>
    
        
        </div>

    </body>
</html>
