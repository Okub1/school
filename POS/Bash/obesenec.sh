#! /bin/bash

# Hru naprogramoval: Jakub Senko, 5ZY034


bolaHraZapnuta=0;
rozohrate=0;
suborSoSlovami='slova.txt'

# Funkcia na vypis menu a zaciatocnu inicializaciu zapnutia programu

function start () {
	clear

	if [[ $bolaHraZapnuta -eq 0 ]]
	then
		echo "Vitajte v hre obesenec!"
		bolaHraZapnuta=1;
		vypisMenu;
	else
		vypisMenu;
	fi

}

function vypisMenu () {
	stty echo;
	echo -e "\nVyberte si jednu z moznosti hry obesenec: "
	echo "1 - Základné informácie o hre"
	echo "2 - Ako vyzera sibenica?"

	if [[ $rozohrate -eq 0 ]]
	then
		echo "3 - Hrat hru";
	else
		echo "3 - Pokracovat v hre";
	fi
	echo "4 - O tvorcovi"
	echo "0 - koniec hry"
	vyberVolby;
	return 0;
}


# Funkcia na vyber volby

function vyberVolby () {

	read -p "Prosim zadajte volbu: " volba


	if [[ -z $volba ]]
        then
		vyberVolby;
        else
                case "$volba" in
       	                1) zakladneInfoOHre;;
       	                2) sibenica;;
                        3) zacatHru;;
                        4) informacieOAutorovi;;
                        0) koniec;;
                        *) echo "Nespravna volba."
			   vyberVolby;;
		esac
	fi

	return $volba
}


# Funkcia na vykreslenie sibenice

function sibenica () {

	echo -e "_______________________	"
	echo -e " |		      |		"
	echo -e " |		      O		"
	echo -e " |		     /|\	"
	echo -e " |		      |		"
	echo -e " |		     / \	"
	echo -e " |				"
	echo -e "_|____________________		"
	echo -e "|		       |__	"
	echo -e "|			  |	"
	echo -e "|_________________________|	"

	stlacteCokolvek
	return 0;
}

# Funkcia na nahodny vyber slova zo suboru

hadaneSlovicko;

function vyberNahodneSlovicko () {

	pocetRiadkovSuboru=$(wc -l < $suborSoSlovami)

	nahodneCislo=$(($RANDOM%$pocetRiadkovSuboru))

	if [[ $nahodneCislo -gt 0 ]]
	then
		hadaneSlovicko=$(sed -n "${nahodneCislo}p" $suborSoSlovami)
	else
		vyberNahodneSlovicko
	fi
}

# Funkcia obsahujuca logiku hry:

nespravne=0
function zacatHru () {

	trap stlacteCokolvek SIGINT

	if [[ $rozohrate -eq 0 ]]
	then
		unset vysledok
		unset progress

		vyberNahodneSlovicko

		for ((i=0;i<${#hadaneSlovicko};i++))
		do
			vysledok[$i]="${hadaneSlovicko:i:1}"
			progress[$i]="_"
		done

		progress[0]=${vysledok[0]};
		progress[-1]=${vysledok[-1]};

		rozohrate=1
		nespravne=0
	fi

	kontrolaNespravnych $nespravne
	echo ${progress[@]}

	koniec=0

	while [[ $koniec -eq 0 ]]
	do
		echo -e "\nzadajte pismeno";
		echo -e "\n(Stlacenim nuly alebo CTRL + C si hru pauznete)"

		read -n 1 -s -r pismeno
		stty echo;

		index=0

		if [[ $pismeno == 0 ]]
		then
			stlacteCokolvek
		fi

		if [[ "${vysledok[*]}" == *$pismeno* ]]
		then
			for pis in ${vysledok[@]}
			do
				if [[ $pismeno == $pis ]]
				then
					progress[$index]=${vysledok[$index]}
				fi
			((index++))
			done
		else
			((nespravne++))
		fi

		kontrolaNespravnych $nespravne
		echo $nespravne
		echo ${progress[@]}

		# KONTROLA

		vyhra=0
		for pis in ${progress[@]}
		do
			if [[ $pis == "_" ]]
			then
				continue
			else
				((vyhra++))
			fi
		done

		if [[ $vyhra -eq ${#progress[@]} ]]
		then
			echo "Gratulujem!"
			koniecHry
		fi
	done

	return 0;
}


function kontrolaNespravnych () {

	case "$1" in
                        0)
	clear
	echo -e "_______________________       "
        echo -e " |                   	       "
        echo -e " |                   	       "
        echo -e " |                  	       "
        echo -e " |                   	       "
        echo -e " |                  	       "
        echo -e " |                            "
        echo -e "_|____________________        "
        echo -e "|                     |_      "
        echo -e "|                       |     "
        echo -e "|_______________________|     "
			;;
                        1)
	clear
        echo -e "_______________________       "
        echo -e " |                   |        "
        echo -e " |                   	       "
        echo -e " |                  	       "
        echo -e " |                   	       "
        echo -e " |                  	       "
        echo -e " |                            "
        echo -e "_|____________________        "
        echo -e "|                     |_      "
        echo -e "|                       |     "
        echo -e "|_______________________|     "

			;;
                        2)
	clear
        echo -e "_______________________       "
        echo -e " |                   |        "
        echo -e " |                   O        "
        echo -e " |                            "
        echo -e " |                   	       "
        echo -e " |                            "
        echo -e " |                            "
        echo -e "_|____________________        "
        echo -e "|                     |_      "
        echo -e "|                       |     "
        echo -e "|_______________________|     "

                        ;;
                        3)
	clear
        echo -e "_______________________       "
        echo -e " |                   |        "
        echo -e " |                   O        "
        echo -e " |                   |        "
        echo -e " |                   	       "
        echo -e " |                  	       "
        echo -e " |                            "
        echo -e "_|____________________        "
        echo -e "|                     |_      "
        echo -e "|                       |     "
        echo -e "|_______________________|     "
			;;
                        4)
	clear
        echo -e "_______________________       "
        echo -e " |                   |        "
        echo -e " |                   O        "
        echo -e " |                  /|        "
        echo -e " |                   	       "
        echo -e " |                  	       "
        echo -e " |                            "
        echo -e "_|____________________        "
        echo -e "|                     |_      "
        echo -e "|                       |     "
        echo -e "|_______________________|     "
			;;
			5)
	clear
        echo -e "_______________________       "
        echo -e " |                   |        "
        echo -e " |                   O        "
        echo -e " |                  /|\       "
        echo -e " |                   	       "
        echo -e " |                  	       "
        echo -e " |                            "
        echo -e "_|____________________        "
        echo -e "|                     |_      "
        echo -e "|                       |     "
        echo -e "|_______________________|     "
			;;
			6)
	clear
        echo -e "_______________________       "
        echo -e " |                   |        "
        echo -e " |                   O        "
        echo -e " |                  /|\       "
        echo -e " |                   |        "
        echo -e " |                  	       "
        echo -e " |                            "
        echo -e "_|____________________        "
        echo -e "|                     |_      "
        echo -e "|                       |     "
        echo -e "|_______________________|     "
			;;
			7)
	clear
        echo -e "_______________________       "
        echo -e " |                   |        "
        echo -e " |                   O        "
        echo -e " |                  /|\       "
        echo -e " |                   |        "
        echo -e " |                  / 	       "
        echo -e " |                            "
        echo -e "_|____________________        "
        echo -e "|                     |_      "
        echo -e "|                       |     "
        echo -e "|_______________________|     "
			;;
			8)
	clear
        echo -e "_______________________       "
        echo -e " |                   |        "
        echo -e " |                   O        "
        echo -e " |                  /|\       "
        echo -e " |                   |        "
        echo -e " |                  / \       "
        echo -e " |                            "
        echo -e "_|____________________        "
        echo -e "|                     |_      "
        echo -e "|       ded             |     "
        echo -e "|_______________________|     "
	echo -e "Koniec Hry."
	echo -e "Hadane slovo bolo: '$hadaneSlovicko'"
	rozohrate=0
	stlacteCokolvek
			;;
                esac

	return 0

}


function koniecHry () {
	rozohrate=0
	stlacteCokolvek
}


# Vypise zakladne informacie o hre - popis hry zo vzdelavania.

function zakladneInfoOHre () {
	echo -e "
		Obesenec je vzdelávacia hra, ktorá učí nové slová alebo slovné spojenia
		a tak rozširuje slovnú zásobu a vedomosti. Cieľom hry je uhádnuť slovo (slovné spojenie)
		pričom máte iba obmedzený počet chybných krokov. Zo slova poznáme začiatočné, koncové písmeno
		 a celkový počet znakov. Ostatné písmena hádame stlačením klávesy pre daný znak.
		Každé správne uhádnuté písmeno sa zobrazí v hľadanom slove. Pokiaľ zadáme nesprávny znak,
		pribudne dielik na šibenicu pre obesenca. Hra končí uhádnutím slova, alebo vybudovaním šibenice s obesencom.
		"
	stlacteCokolvek;
	return 0;
}


# Funkcia na vypis informacii o autorovi programu.

function informacieOAutorovi () {
	echo -e "Hru naprogramoval: Jakub Senko, 5ZY034 - 2019/2020";
        stlacteCokolvek;
	return 0;
}


# Pomocna funkcia, aby som to nemusel vsade prepisovat...

function stlacteCokolvek () {
	trap - SIGINT  #reset SIGINT (CTRL + C)


	echo -e "\nStlacte cokolvek pre navrat do menu..."
        read -n 1 -s -r

	stty echo;
        vypisMenu;
	return 0;
}



# Funkcia na koniec celeho programu.

function koniec () {
	echo "Koniec programu.";
	stty echo;
	exit 1;
}



# sluzi len ako spustac hry po inicializovani vsetkych funkcii.
start;
