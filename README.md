# programu-sistemu-projektavimas
Granto Bičiulaičio Programų sistemų laboratoriniai darbai 2021
2 užduoties branch'as

Validatoriai realizuoti iš šios repozitorijos https://github.com/Mantas-Meow/PSP

Atsiliepimas apie unit test'us:
* Ar buvo aiškūs ir patogūs unit testai, ar kodas aiškus?  
Kodas buvo suprantamas, nesudėtingas, tačiau gana nepatogus. Didžiausia problema buvo, kad iš kiekvieno testo buvo kviečiamas lygiai tie patys „validateEmail“, „validatePassword“ ir „validatePhoneNumber“ metodai. Aš negaliu sukurti kelių metodų su tuo pačiu pavadinimu kurie daro visiškai skirtingus dalykus tai man teko pakeisti Manto kodą kad būtų kviečiami skirtingi metodai. Būtų galima overload'inti juos su daugiau argumentų tačiau nėra ką daugiau į juos paduoti todėl taip nedariau.  
Taip pat man buvo keista matyti, kad beveik visuose testuose buvo vykdomi priešingi „assert“ metodai negu, mano manymu, turėtų iš tikrųjų būti. Pavyzdžiui, „emailValidator_emptyEmail_shouldReturnFalse“ teste assert'inama, kad emptyEmail metodas grąžina false reikšmę, jeigu paduodama tuščias „email“ string'as. Tačiau man atrodytų logiškiau, jeigu emptyEmail metodas grąžintų true jeigu aptinkamas tuščias email, o ne false. Tačiau buvo ir priešingų atvejų, su kuriais sutikau, kaip tarkim „passwordValidator_hasAnUppercase_shouldReturnTrue“ teste.  
Dar vienas pastebėjimas - „phoneValidator_numberLTChangedToInternational_shouldReturnTrue“ teste buvo prašoma, kad telefono numeriai, prasidedantys su 8 būtų pakeisti į +370 tačiau kviečiamas metodas reikalavo, jog būtų grąžinamas booleanas, jog tas stringas buvo pakeistas, o ne pats pakeistas string'as. Man tai pasirodė labai keista.  
Taip pat buvo ir gana daug gramatinių klaidų pavadinimuose. Stengiausi kuo mažiau keisti Manto kodą, todėl dalykų, kurių neprivalau keisti, ir nekeičiau.
  
* Kaip jūs galėtumėte juos pagerinti?  
Juos dėja jau teko gerinti, keičiant kviečiamų metodų pavadinimus. Taip pat pakeisčiau ir beveik visus assert'us į jiems priešingus, ištaisyčiau „phoneValidator_numberLTChangedToInternational_shouldReturnTrue“ klaidą ir visas gramatines ir rašybos klaidas.  
  
* Kokius unit testus jūs galėtumėte pridėti (jei tokių yra)?  
Jokių. Manto sukurtų testų pilnai užteko.
