@adileos1
@adileos
@cond-util

Feature: [ ADILEOS ] Conditions d'utilisation

Scenario: Conditions d'utilisation
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Accéder au lien 'Conditions d'utilisation'
    Then MENT_OFF La page de titre 'Conditions d’utilisation' s'affiche
    When MENT_OFF Accéder au lien 'DOC-DEPOT'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    
    