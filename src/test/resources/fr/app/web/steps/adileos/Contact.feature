@adileos3
@adileos
@contact-adileos

Feature: [ ADILEOS ] Contact

Scenario: Nous Contacter
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Accéder au lien 'Nous contacter'
    Then PORT_ADILEOS Le portail ADILEOS s'affiche dans l'onglet 'Contact'
    When PORT_ADILEOS Revenir à la page précédente
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche