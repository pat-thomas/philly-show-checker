set -exu
mysql.server restart
#sudo mysqladmin create philly_show_checker
sudo mysql -e "CREATE USER 'db_admin'@'localhost' IDENTIFIED BY '1234';"
