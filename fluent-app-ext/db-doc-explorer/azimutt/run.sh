openssl rand -hex 64


docker pull ghcr.io/azimuttapp/azimutt:main
db_url=$1
npx azimutt explore $db_url
npx azimutt@latest gateway