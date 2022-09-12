<?php
 include "config.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $lang['header-über-mich']?></title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="shortcut icon" href="images/icon/mstile-310x310.png"/>
    <link rel="icon" href="images/icon/mstile-310x310.png"/>

</head>

<style>
    <?php include "style.css" ?>
</style>

<body>
    <header id="header">
        
        <div class="logo-logo-name">
            <a href="index.php">
                <div id="logo">
                     ZT
                </div>
            </a>
        
            <a href="index.php">
                <div id="logo-name">
                    <span id="Zinedine">Zinedine</span> <br>Tomasella
                </div>
            </a>

        </div>

        <div class="nav-bar-container">
            <a href="http://localhost/Website/index.php" class="nav-bar"><?php echo $lang['Home']?></a> 
            <a href="http://localhost/Website/kontakt.php" class="nav-bar"><?php echo $lang['Contact']?></a>
            <a href="http://localhost/Website/übermich.php" class="nav-bar"><?php echo $lang['About me']?></a> 
            <a href="http://localhost/Website/meineProjekte.php" class="nav-bar"><?php echo $lang['my Projects']?></a>
            
            <div class="dropdown">
                <img class="nav-bar" src="images/icon/globus.png" alt="language" onclick="myFunction()">
                <div class="dropdown-content" id="myDropdown">
                    <div class="first-language">
                        <a href="?lang=de" data-reload><?php echo $lang['de']?></a>
                        <img class="germany" src="images/icon/germany.png" alt="Germany">
                    </div>
                    <div class="second-language">
                        <a href="?lang=en"data-reload><?php echo $lang['en']?></a>
                        <img class="united-kingdom" src="images/icon/england.png" alt="United Kingdom">
                    </div>
                </div>
            </div>  
        </div>
    
    </header>


    <main id="main"> 
        <div class="hintergrund-übermich">
            <h1 class="das-bin-ich-title">
                <?php echo $lang['hi me']?> 
            </h1>

            <div class="text">
                <?php echo $lang['übermich-text']?>
                <hr />
                <?php echo $lang['übermich-text2']?>
                <hr />
                <?php echo $lang['übermich-text3']?>
                <?php echo $lang['übermich-text4']?>
                <?php echo $lang['übermich-text5']?>
                <br> <br>
                <div class="übermich-datum"> <?php echo $lang['datUnterschrift']?> </div>
                <img class="bitmoji-avatar" src="images/zini-removebg-preview.png" alt="My Bitmoji Avatar">
            </div>
        </div> 
    </main>

    <footer class="footer">
        <div class="background">
            <div class="copyright">
                    © 2022 Zinedine Tomasella
            </div>
        </div>
    </footer>

</body>
<script src="app.js">
</script>
</html>