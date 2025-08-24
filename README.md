# SoftwareSecurity

Module Eight Journal — README Snippet

artifact

Practices for Secure Software Report in this repo

client and need

Client is Artemis Financial

Public web app needed stronger security

I added HTTPS and a SHA-256 checksum step

what I did well

Found risky old libraries

Added TLS and checksum without breaking the app

Wrote clear steps and screenshots

why secure code matters

Protects users and data

Builds trust

Lowers risk and cost

hardest part

Sorting the dependency report

Learning what I should fix now vs later upgrades

how I added layers

HTTPS on port 8443 with a self signed cert

SHA-256 checksum at the hash endpoint

Clean config and no secrets in code

future approach

Use OWASP Top Ten

Do threat modeling

Run SAST and DAST

Plan regular version upgrades

how I checked function and security

Ran the app and hit
https://localhost:8443/hash?data=Ryan-Davis-2025-08-24
