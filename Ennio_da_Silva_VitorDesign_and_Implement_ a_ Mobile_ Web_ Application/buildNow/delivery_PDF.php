<?php
    if($_GET['id']){

        $user_id= $_GET['id'];



        try {

            include('db.php');


            $sql = "SELECT users.fName, users.surname, users.address, users.telephone, orders.items
                    FROM buildnow.users
                    INNER JOIN buildnow.orders
                    ON users.user_id=? AND orders.user_id=?
                    ";

            $sth = $DBH->prepare($sql);

            $sth->bindParam(1,$user_id, PDO::PARAM_INT);
            $sth->bindParam(2,$user_id, PDO::PARAM_INT);

            $sth->execute();




            while ($row = $sth->fetch(PDO::FETCH_ASSOC)) {


                $fName = $row['fName'];
                $surname = $row['surname'];
                $address = $row['address'];
                $telephone = $row['telephone'];
                    $items = $row['items'];
                    $item = explode(" ", $items);
                        $i = $item [0];
                        $i1 = $item [1];
                        $i2 = $item [2];
                        $i3 = $item [3];
                        $i4 = $item [4];
                        $i5 = $item [5];
                        $i6 = $item [6];
                        $i7 = $item [7];
                        $i8 = $item [8];
                        $i9 = $item [9];
                        
                        
                        


                            $sql = "SELECT name, description, price FROM buildnow.products
                            WHERE product_id = ?;";

                            $sth = $DBH->prepare($sql);

                            $sth->bindParam(1,$i, PDO::PARAM_INT);
                            
                            $sth->execute();
                            $row = $sth->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName = $row['name'];
                            $itemExplodedDescription = $row['description'];
                            $itemExplodedPrice = $row['price'];

                            
                            //next product
                            
                            $sth1 = $DBH->prepare($sql);

                            $sth1->bindParam(1,$i1, PDO::PARAM_INT);
                            
                            $sth1->execute();
                            $row1 = $sth1->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName1 = $row1['name'];
                            $itemExplodedDescription1 = $row1['description'];
                            $itemExplodedPrice1 = $row1['price'];
                            
                            //next product
                            
                            $sth2 = $DBH->prepare($sql);

                            $sth2->bindParam(1,$i2, PDO::PARAM_INT);
                            
                            $sth2->execute();
                            $row2 = $sth2->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName2 = $row2['name'];
                            $itemExplodedDescription2 = $row2['description'];
                            $itemExplodedPrice2 = $row2['price'];
                            
                            //next product
                            
                            $sth3 = $DBH->prepare($sql);

                            $sth3->bindParam(1,$i3, PDO::PARAM_INT);
                            
                            $sth3->execute();
                            $row3 = $sth3->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName3 = $row3['name'];
                            $itemExplodedDescription3 = $row3['description'];
                            $itemExplodedPrice3 = $row3['price'];
                            
                            //next product
                            
                            $sth4 = $DBH->prepare($sql);

                            $sth4->bindParam(1,$i4, PDO::PARAM_INT);
                            
                            $sth4->execute();
                            $row4 = $sth4->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName4 = $row4['name'];
                            $itemExplodedDescription4 = $row4['description'];
                            $itemExplodedPrice4 = $row4['price'];
                            
                            //next product
                            
                            $sth5 = $DBH->prepare($sql);

                            $sth5->bindParam(1,$i5, PDO::PARAM_INT);
                            
                            $sth5->execute();
                            $row5 = $sth5->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName5 = $row5['name'];
                            $itemExplodedDescription5 = $row5['description'];
                            $itemExplodedPrice5 = $row5['price'];
                            
                             //next product
                            
                            $sth6 = $DBH->prepare($sql);

                            $sth6->bindParam(1,$i6, PDO::PARAM_INT);
                            
                            $sth6->execute();
                            $row6 = $sth6->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName6 = $row6['name'];
                            $itemExplodedDescription6 = $row6['description'];
                            $itemExplodedPrice6 = $row6['price'];
                            
                            //next product
                            
                            $sth7 = $DBH->prepare($sql);

                            $sth7->bindParam(1,$i7, PDO::PARAM_INT);
                            
                            $sth7->execute();
                            $row7 = $sth7->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName7 = $row7['name'];
                            $itemExplodedDescription7 = $row7['description'];
                            $itemExplodedPrice7 = $row7['price'];
                            
                            //next product
                            
                            $sth8 = $DBH->prepare($sql);

                            $sth8->bindParam(1,$i8, PDO::PARAM_INT);
                            
                            $sth8->execute();
                            $row8 = $sth8->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName8 = $row8['name'];
                            $itemExplodedDescription8 = $row8['description'];
                            $itemExplodedPrice8 = $row8['price'];
                            
                            //next product
                            
                            $sth9 = $DBH->prepare($sql);

                            $sth9->bindParam(1,$i9, PDO::PARAM_INT);
                            
                            $sth9->execute();
                            $row9 = $sth9->fetch(PDO::FETCH_ASSOC);
                       

                            $itemExplodedName9 = $row9['name'];
                            $itemExplodedDescription9 = $row9['description'];
                            $itemExplodedPrice9 = $row9['price'];
                            
                            
                            
                            
            }
        
    
        
        require('fpdf.php');

        class PDF extends FPDF{
            // Page header
            function Header(){
                $this->Ln(10);
                // Arial bold 15
                $this->SetFont('Arial','B',15);
                // Move to the right
                $this->Cell(50);
                // Title
                $this->Cell(90,20,'Build Now Ltd. (Receipt)',1,0,'C');
                // Line break
                $this->Ln(20);
            }

            // Page footer
            function Footer(){
                // Position at 1.5 cm from bottom
                $this->SetY(-15);
                // Arial italic 8
                $this->SetFont('Arial','I',8);
                // Page number
                $this->Cell(0,10,'Page '.$this->PageNo().'/{nb}',0,0,'C');
            }
        }

        // Instanciation of inherited class
        $pdf = new PDF();
        $pdf->AddPage();
        $pdf->SetFont('Arial','B',16);
        
        $pdf->Cell(1,50,$fName);
        
        $pdf->Cell(1,80,$address);
        $pdf->Cell(1,110,$telephone);
        
       
        $pdf->Cell(1,230,$itemExplodedName8);
        $pdf->Cell(1,220,$itemExplodedName7);
        $pdf->Cell(1,210,$itemExplodedName6);
        $pdf->Cell(1,200,$itemExplodedName5);
        $pdf->Cell(1,190,$itemExplodedName4);
        $pdf->Cell(1,180,$itemExplodedName3);
        $pdf->Cell(1,170,$itemExplodedName2);
        $pdf->Cell(1,160,$itemExplodedName1);
        $pdf->Cell(30,150,$itemExplodedName);
        
        $pdf->Cell(10,50,$surname);
        
        
  
        $pdf->Cell(1,230,$itemExplodedDescription8);
        $pdf->Cell(1,220,$itemExplodedDescription7);
        $pdf->Cell(1,210,$itemExplodedDescription6);
        $pdf->Cell(1,200,$itemExplodedDescription5);
        $pdf->Cell(1,190,$itemExplodedDescription4);
        $pdf->Cell(1,180,$itemExplodedDescription3);
        $pdf->Cell(1,170,$itemExplodedDescription2);
        $pdf->Cell(1,160,$itemExplodedDescription1);
        $pdf->Cell(100,150,$itemExplodedDescription);
        
        
   
        $pdf->Cell(1,230,$itemExplodedPrice8);
        $pdf->Cell(1,220,$itemExplodedPrice7);
        $pdf->Cell(1,210,$itemExplodedPrice6);
        $pdf->Cell(1,200,$itemExplodedPrice5);
        $pdf->Cell(1,190,$itemExplodedPrice4);
        $pdf->Cell(1,180,$itemExplodedPrice3);
        $pdf->Cell(1,170,$itemExplodedPrice2);
        $pdf->Cell(1,160,$itemExplodedPrice1);
        $pdf->Cell(10,150,$itemExplodedPrice);
        
        
        
        
        
        
        
        $pdf->Output();
      
        
        } catch(PDOException $e) {echo $e;}
        
        
    }   
        
        
?>