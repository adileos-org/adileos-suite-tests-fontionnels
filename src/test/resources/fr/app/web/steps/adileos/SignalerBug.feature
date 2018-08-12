@adileos4
@adileos
@signaler-bug

Feature: [ ADILEOS ] Contact - Signaler un bug

Scenario: Signaler un bug
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Accéder au lien 'Signaler un bug ou demander une évolution.'
    Then PORT_ADILEOS Le portail ADILEOS s'affiche dans l'onglet 'Contact'
    When PORT_ADILEOS Revenir à la page précédente
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche