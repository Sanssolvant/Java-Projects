<?php
 include "config.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>meine Projekte</title>
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

    
    <main id="main-meineProjekte">
      <div class="slider">

      <div class="slide active">
        <div class="info">

          <h1 class="meineProjekte-text-title">
            <?php echo $lang['viergewinnt-title']?>
          </h1>

          <div class="meineProjekte-text">
            <?php echo $lang['viergewinnt-text']?> 
            <br> 
            <?php echo $lang['Players']?>
            <br>
            <a href="images/download/Vier-Gewinnt.jar" download>
              <?php echo $lang['Download']?>
            </a>
          </div>

          <img class="java-logo" src="images/logos/java-neu.png" alt="java logo">

        </div>
        
      </div>

      <div class="slide">

        <div class="info">

          <h1 class="meineProjekte-text-title">
            <?php echo $lang['bankomat-title']?>
          </h1>

          <div class="meineProjekte-text">
            <?php echo $lang['bankomat-text']?> 
            <br> 
            <?php echo $lang['MySql']?>
            <br> 
            <a href="images/download/Bankomat.jar" download>
              <?php echo $lang['Download']?>
            </a>
          
          </div>

          <img class="java-logo" src="images/logos/java-neu.png" alt="java logo">

        </div>

      </div>

      <div class="slide">

        <div class="info">

          <h1 class="meineProjekte-text-title">
            <?php echo $lang['umrechner-title']?>
          </h1>

          <div class="meineProjekte-text">
            <?php echo $lang['umrechner-text']?>
            <br> 
            <a href="images/download/Umrechner.jar" download>
              <?php echo $lang['Download']?>
            </a>
          
          </div>

          <img class="java-logo" src="images/logos/java-neu.png" alt="java logo">

        </div>

      </div>

      <div class="slide">

        <div class="info">

          <h1 class="meineProjekte-text-title">
            <?php echo $lang['zeitmesser-title']?>
          </h1>

          <div class="meineProjekte-text">
            <?php echo $lang['zeitmesser-text']?>
            <br> 
            <a href="images/download/ProgrammDauerMessen.jar" download>
              <?php echo $lang['Download']?>
            </a>
          
          </div>

          <img class="java-logo" src="images/logos/java-neu.png" alt="java logo">

        </div>

      </div>

      <div class="slide">

        <div class="info">

          <h1 class="meineProjekte-text-title">
            <?php echo $lang['webseite-title']?>
          </h1>

          <div class="meineProjekte-text">
            <?php echo $lang['html-text']?> <br> <?php echo $lang['standard-languages']?> <span class="hsj"> <?php echo $lang['html']?> </span> 
          </div>

          <img class="java-logo" src="images/logos/website-language.png" alt="java logo">

        </div>

      </div>

      <div class="navigation">
        <i class="fas fa-chevron-left prev-btn"></i>
        <i class="fas fa-chevron-right next-btn"></i>
      </div>
      <div class="navigation-visibility">
        <div class="slide-icon active"></div>
        <div class="slide-icon"></div>
        <div class="slide-icon"></div>
        <div class="slide-icon"></div>
        <div class="slide-icon"></div>
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
<script type="text/javascript" src="meineProjekte.js">
</script>
</html>