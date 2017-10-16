<!DOCTYPE html>
<html>
    <head>
        <title> Login</title>
        
        <?php
            include('header.php');
        ?>
        
        
        
    </head>
    <body>
            <?php
                include('db.php');
            ?>
            <?php
        
            if($_POST){
               $fName = $_POST['text-3'];
               $surname = $_POST['text-4'];
               $address = $_POST['text-5'];
               $telephone = $_POST['text-6'];
               $e_mail = $_POST['text-7'];
               $salt = "123";
               $password = $_POST['text-8'].$salt;
               $password = md5($_POST['text-8']);
               $type = $_POST['text-9'];
    
                
               
               
               try { 

                    


                    $sql = "INSERT INTO `users` (`fName`, `surname`, `address`, `telephone`,`e_mail`, `password`,`type`) VALUES (?, ?, ?, ?, ?, ?, ?);";
                    $sth = $DBH->prepare($sql);

                    $sth->bindParam(1, $fName, PDO::PARAM_INT);
                    $sth->bindParam(2, $surname, PDO::PARAM_INT);
                    $sth->bindParam(3, $address, PDO::PARAM_INT);
                    $sth->bindParam(4, $telephone, PDO::PARAM_INT);
                    $sth->bindParam(5, $e_mail, PDO::PARAM_INT);
                    $sth->bindParam(6, $password, PDO::PARAM_INT);
                    $sth->bindParam(7, $type, PDO::PARAM_INT);

                    $sth->execute();

                    echo '== You are now registered! ==';

                } catch(PDOException $e) {echo 'Error' . $e;} 

            }


        ?>

            <form  action="register.php" method="post">
            
           first name:<input type="text" name="text-3"/>

           Surname:<input type="text" name="text-4" />

            Address:<input type="text" name="text-5"/>

            telephone:<input type="text" name="text-6" />

            E-mail:<input type="text" name="text-7" />

            Password:<input type="text" name="text-8"/>

            
            <br>
       
            Type:<select name="text-9">
                <option value="customer">Customer</option>
            </select>
       
            <br>       
 
            
            <button type="submit" class="ui-btn ui-corner-all">Register! </button>
                    
     
            </form>  
            
            <br>  
        
        <a href="index.php"  data-transition="flip" class="ui-btn">welcome page</a>

        <?php
            include('footer.php');
        ?>
        
        
    </body>
</html>