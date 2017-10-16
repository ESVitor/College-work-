<!DOCTYPE html>

<html>
    <head>
        
        <title> Login</title>
        
        <?php
            include('header.php');
        ?>
        
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    
    <body>
        
              
        <?php
        
        $_SESSION['cart']='';
       
        
        // This will only run if a post happens!!!
            if($_POST){
    
                echo 'Post has occurred<br>';
    
                $e_mail = $_POST['text-1'];
                $salt = "123";
                $password = $_POST['text-2'].$salt;
                $password = md5($_POST['text-2']);
    
                if (!filter_var($e_mail, FILTER_VALIDATE_EMAIL)) {
                    echo 'Sorry you did not enter a correct email! <br>';
                }

                
                if($e_mail == ''){
                    echo 'Enter a username<br>';
                } 
                    
                if($password == ''){
                    echo 'Enter a password<br>';
                }
                
                if(strlen($password) < 8){
                            echo 'Sorry to short!<br>';
                }
                
                
    
                // DB
                try {

                    include('db.php');

                    $sql = "select * from users where e_mail = ? and password = ?";
                    $sth = $DBH->prepare($sql);

                    $sth->bindParam(1,$e_mail, PDO::PARAM_INT);
                    $sth->bindParam(2,$password, PDO::PARAM_INT);


                    $sth->execute();

                    if ($sth->rowCount() > 0){


                        // Getting row from the db
                        $rec = $sth->fetch(PDO::FETCH_ASSOC);

                        // getting values from the row            
                        $user_id = $rec['user_id'];
                        $type = $rec['type'];

                        if($type == 'customer'){
                            
                            
                           echo '<script>window.location="customer.php?user_id='.$user_id.'" </script>';
                           die;
                        }

                        elseif($type == 'staff'){

                           echo '<script>window.location="staff.php" </script>';
                           die;
                        }

                        elseif($type == 'delivery'){

                           echo '<script>window.location="delivery.php" </script>';
                           die;
                        }

                        elseif($type == 'admin'){

                           echo '<script>window.location="admin.php" </script>';
                           die;
                        }
                    }
                } catch(PDOException $e) {echo $e;}  
            }
        ?>
         
        
        <form  action="login.php" method="post">
     
            E-mail:<input type="text" name="text-1" id="text-1"/>

            Password:<input type="password" name="text-2" id="text-2"/>
            
            <br/>
            <?php

                require_once('recaptchalib.php');

                // Get a key from https://www.google.com/recaptcha/admin/create
                $publickey = "6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI";
                $privatekey = "6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe";

                # the response from reCAPTCHA
                $resp = null;
                # the error code from reCAPTCHA, if any
                $error = null;

                # was there a reCAPTCHA response?
                if (isset($_POST["recaptcha_response_field"])) {
                        $resp = recaptcha_check_answer ($privatekey,
                                                        $_SERVER["REMOTE_ADDR"],
                                                        $_POST["recaptcha_challenge_field"],
                                                        $_POST["recaptcha_response_field"]);

                    if ($resp->is_valid) {
                        echo "You got it!";
                    
                    } 
                    
                        else {
                            # set the error code so that we can display it
                            $error = $resp->error;
                        }
                }
                echo recaptcha_get_html($publickey, $error);
            ?>
            <br/>
            
            <button type="submit" class="ui-btn ui-corner-all">Login! </button>
         
        </form>
    
        <a href="index.php"  data-transition="flip" class="ui-btn">Welcome page</a>
        
        <?php
            include('footer.php');
        ?> 
           
   </body>
</html>