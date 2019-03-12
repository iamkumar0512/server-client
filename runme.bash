javac server.java 2>/dev/null
javac server.client 2>/dev/null
touch serveroutput.txt
touch clientoutput.txt
echo -e "---------Client Output-----------" >| clientoutput.txt
echo -e "---------Server Output-----------" >| serveroutput.txt
java server 1>>serveroutput.txt 2>/dev/null &
java client 1>>clientoutput.txt 2>/dev/null
echo -e "---------------------------------" >> clientoutput.txt
echo -e "---------------------------------" >> serveroutput.txt
cat clientoutput.txt
cat serveroutput.txt

