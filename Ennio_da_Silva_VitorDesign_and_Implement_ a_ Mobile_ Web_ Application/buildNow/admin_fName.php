<!DOCTYPE html>



<html>
    
    <head>
        
        <title> AdminFName</title>
        
        <?php
            include('header.php');
        ?>
    
    </head>
    
       
    <body>
        
        <div id="div2" >
        
            <?php
           
                if($_POST){
                    
                    $user_id = $_POST['text-1'];
                    $fName = $_POST['text-2'];
                
                    try {
                        
                        include('db.php');
                        
                        $sql = "UPDATE users SET fName = ? WHERE user_id= ?";
                        $sth = $DBH->prepare($sql);

                        
                        $sth->bindParam(1,$fName, PDO::PARAM_INT);
                        $sth->bindParam(2,$user_id, PDO::PARAM_INT);

                        $sth->execute();
  
                    } catch(PDOException $e) {echo $e;}
                
                echo '<h3 style="color:red">The first name is updated</h3><br>';    
                }
            ?>
            <br>
            <h3>Edit user's first name</h3>
            
            <form action="#div2" method="post">
            
               User ID:<input type="text" name="text-1" id="text-1"/>
               First name:<input type="text" name="text-2" id="text-2"/>
               <button type="submit1" class="ui-btn ui-corner-all">update! </button>
            
            </form>
        
        </div>
        
        <a href="admin.php"  data-transition="fade" class="ui-btn">Return to administrator page</a>
        
        <?php
            include('footer.php');
        ?>
        
    </body>
</html>    