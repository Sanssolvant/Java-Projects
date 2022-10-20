<?php

include "config.php";

require 'C:\xampp\htdocs\Website\PHPMailer\Exception.php';
require 'C:\xampp\htdocs\Website\PHPMailer\PHPMailer.php';
require 'C:\xampp\htdocs\Website\PHPMailer\SMTP.php';

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
use PHPMailer\PHPMailer\SMTP;

$message_sent = 0;

if (isset($_POST['submit']) && isset($_POST['mail']) && $_POST['mail'] != '') {

    $message_sent = 2;
    if (filter_var($_POST['mail'], FILTER_VALIDATE_EMAIL)) {
        $mailer = new PHPMailer();
        $mailer->isSMTP();
        $mailer->Host = "smtp.hispeed.ch";
        $mailer->SMTPAuth = true;
        $mailer->Username = "zinedine.tomasella@hispeed.ch";
        $mailer->Password = "etuensla";

        $name = $_POST['name'];
        $subject = $_POST['subject'];
        $mailFrom = $_POST['mail'];
        $message = $_POST['message'];

        $txt = "You have received an e-mail from " . $name . ".\n\n Message: " . $message;

        $mailer->setFrom($mailFrom);
        $mailer->addAddress("zinedine.tomasella@hispeed.ch", "Z.Tomasella");
        $mailer->Subject = $subject;
        $mailer->Body = $txt;

        $message_sent = 1;
        $mailer->send();
    }
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $lang['header-kontakt'] ?></title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="shortcut icon" href="images/icon/mstile-310x310.png" />
    <link rel="icon" href="images/icon/mstile-310x310.png" />

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
            <a href="http://localhost/Website/index.php" class="nav-bar"><?php echo $lang['Home'] ?></a>
            <a href="http://localhost/Website/kontakt.php" class="nav-bar"><?php echo $lang['Contact'] ?></a>
            <a href="http://localhost/Website/übermich.php" class="nav-bar"><?php echo $lang['About me'] ?></a>
            <a href="http://localhost/Website/meineProjekte.php" class="nav-bar"><?php echo $lang['my Projects'] ?></a>

            <div class="dropdown">
                <img class="nav-bar" src="images/icon/globus2.png" alt="language" onclick="myFunction()">
                <div class="dropdown-content" id="myDropdown">
                    <div class="first-language">
                        <a href="?lang=de" data-reload><?php echo $lang['de'] ?></a>
                        <img class="germany" src="images/icon/germany.png" alt="Germany">
                    </div>
                    <div class="second-language">
                        <a href="?lang=en" data-reload><?php echo $lang['en'] ?></a>
                        <img class="united-kingdom" src="images/icon/england.png" alt="United Kingdom">
                    </div>
                </div>
            </div>
        </div>

    </header>

    <?php
    if ($message_sent == 1) :
    ?>
        <div id="alert-success">
            <span><?php echo $lang['alert-success'] ?></span>
        </div>
    <?php
    elseif ($message_sent == 2) :
    ?>
        <div id="alert-error">
            <span><?php echo $lang['alert-error'] ?></span>
        </div>
    <?php
    endif;
    ?>

    <main id="main">
        <div class="main-kontakt">

            <div class="contact-section">

                <div class="contact-info">
                    <div><i class="fa-solid fa-location-dot"></i>Gasterweg 33, Uznach, Switzerland</div>
                    <div><i class="fa-solid fa-envelope"></i>zinedine.tomasella@hispeed.ch</div>
                    <div><i class="fa-solid fa-phone"></i>+41 78 8052404</div>
                </div>

                <div class="contact-form">
                    <h1><?php echo $lang['contact-form'] ?></h1>
                    <form class="contact" action="kontakt.php" method="POST">
                        <input type="text" name="name" class="text-box" placeholder=<?php echo $lang['Your Name'] ?> spellcheck="false" required>
                        <input type="text" name="mail" class="text-box" placeholder=<?php echo $lang['Your Email'] ?> spellcheck="false" required>
                        <input type="text" name="subject" class="text-box-subject" placeholder=<?php echo $lang['Subject'] ?> spellcheck="false" required>
                        <textarea name="message" rows="5" placeholder=<?php echo $lang['Message'] ?> spellcheck="false" required></textarea>
                        <button type="submit" name="submit" class="send-btn"> <?php echo $lang['Send'] ?> </button>
                    </form>
                </div>
            </div>
        </div>
    </main>

    <footer class="footer">
        <a class="socials" href="https://github.com/Sanssolvant/Projects"><i class="fa-brands fa-github" aria-hidden="true"></i>&nbsp; Github</a>
        <div class="background">
            <div class="copyright">
                © 2022 Zinedine Tomasella
            </div>
        </div>
    </footer>

</body>
<script type="text/javascript" src="kontakt.js">
</script>

</html>