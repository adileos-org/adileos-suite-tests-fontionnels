@adileos2
@adileos
@mentions-legales

Feature: [ ADILEOS ] Mentions Légales

Scenario: Conditions d'utilisation
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Accéder au lien 'Mentions légales.'
    Then MENT_OFF La page de titre 'Mentions légales' s'affiche
    When MENT_OFF Revenir à la page précédente
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    
    