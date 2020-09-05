Fiori-App-MaterialList

Eduard Gradwald

Die App wurde von Eduard Gradwald am 05.09.2020 erstellt und deployed. Das Projekt wird unterstützt von: peritia Consulting GmbH.

Dokumentation. Fiori-MaterialList Applikation.

Material anlegen/ändern:

    Material-NR : ID-Schlüssel (Eingabe-Pflicht)
    Material-Name : MaterialName(String, Nullabble)
    Erstelldatum : Erstelldatum(EDM.Date/Time , SAP Format, BSP: 2020-01-01T12:00:00, obligatorisch)
    Erstellt von : Erstellt von(String, SAP-Format)
    Mengeneinheit : Mengeneinheit(SAP Format, obligatorisch, BSP: Siehe unten "Mengeneinheit" )

Mengeneinheit: SAP-basiert:

ST - Stück, STD -Stunden, T - Tage, TTE - Tüte, N - Newton, MS - Millisekunde, V- Volt, M2- Quadratmeter, M - Meter, L - Liter, KS - Kasten, KM - Kilometer, A - Ampere, % - Prozent, ......................usw. Siehe SAP-Basismengeneinheiten

:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: Material löschen:

    Material-NR : ID-Schlüssel (Eingabe-Pflicht)

