<!DOCTYPE html>



<html>
    
    <head>
        
        <title> AdminListOfUsers</title>
        
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
           <h3>List of users</h3><br>
            <?php
                
                 
                try {

                    include('db.php');


                    $sql = "select * from users";
                    $sth = $DBH->prepare($sql);

                    $sth->execute();


                    echo '<table>';
                        echo '<tr> <td><b>ID</b></td> <td><b>Name</b></td> <td><b>Surname</b></td> <td><b>Address</b></td> <td><b>Telephone<b></td> <td><b>E-mail<b></td> <td><b>Password<b></td> <td><b>Account type<b></td>  </tr>';    

                        while ($row = $sth->fetch(PDO::FETCH_ASSOC)) {


                        $id = $row['user_id'];
                        $name = $row['fName'];
                        $surname = $row['surname'];
                        $address = $row['address'];
                        $telephone = $row['telephone'];
                        $e_mail = $row['e_mail'];
                        $password = $row['password'];
                        $type = $row['type'];
                        
                        echo '<tr>'; 
                            echo '<td>' . $id . '</td>'; 
                            echo '<td>' . $name . '</td>'; 
                            echo '<td>' . $surname . '</td>'; 
                            echo '<td>' . $address . '</td>'; 
                            echo '<td>' . $telephone . '</td>';
                            echo '<td>' . $e_mail . '</td>';
                            echo '<td>' . $password . '</td>';
                            echo '<td>' . $type . '</td>';
                        echo '</tr>';     

                        }
                    echo '</table>';

                } catch(PDOException $e) {echo $e;}
            
            ?>

           
        
        </div>
        <br>
        <a href="admin.php"  data-transition="fade" class="ui-btn">Return to administrator page</a>
        
        <?php
            include('footer.php');
        ?>
        
    </body>
</html>    
        
    