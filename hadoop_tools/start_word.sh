$HADOOP_HOME/bin/stop-all.sh
$HADOOP_HOME/bin/hadoop namenode -format
$HADOOP_HOME/bin/start-all.sh
jps

hadoop fs -put $HADOOP_HOME/conf/hadoop-env.sh conf/hadoop-env.sh
hadoop jar hadoop-examples-*.jar wordcount /conf/hadoop-env.sh wordcount_output
