<!DOCTYPE html>



<html>
    
    <head>
        
        <title> AdminListOfUsers</title>
        
        <?php
            include('header.php');
        ?>
    
    </head>
    
   
    <body>
        
       <div id="div3" >
        
            <?php
            
                if($_POST){
                    
                    $user_id1 = $_POST['text-3'];
                    $surname1 = $_POST['text-4'];
                
                    try {

                        include('db.php');

                        
                        $sql = "UPDATE users SET surname = ? WHERE user_id= ?";
                        $sth = $DBH->prepare($sql);

                        
                        $sth->bindParam(1,$surname1, PDO::PARAM_INT);
                        $sth->bindParam(2,$user_id1, PDO::PARAM_INT);

                        $sth->execute();
  
                    } catch(PDOException $e) {echo $e;}
                
                echo '<h3 style="color:red">The surname is updated</h3><br>';    
                }
            ?>
            <br>
            <h3>Edit user's surname</h3>
            
            <form action="#div3" method="post">
            
               User ID:<input type="text" name="text-3" id="text-3"/>
               Surname:<input type="text" name="text-4" id="text-4"/>
               <button type="submit" class="ui-btn ui-corner-all">update! </button>
            
            </form>
        
        </div>
        
        <a href="admin.php"  data-transition="fade" class="ui-btn">Return to administrator page</a>
        
        <?php
            include('footer.php');
        ?>
        
    </body>
</html>