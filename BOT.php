<?php

TOKEN="Apagolo otto apagalo";
CHATID = ""

URL = "https://api.telegram.org/bot1730033385:AAG1KRVKsdouWjVK1k5xPD7LOxJ88rjG-R4/getUpdates"

DATE = $(date +"%d-%b-%Y")
TEXT"Backup realizado %DATE"

curl -d "char_id = $CHATID&disab_web_page_preview=$TEXT" &URL
>?