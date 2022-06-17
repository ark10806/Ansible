rm -rf ~/hadoop-data
rm -rf $HADOOP_HOME/tmp
rm -rf $HADOOP_HOME/pids

ssh hadoop@pi0 "rm -rf ~/hadoop-data"
ssh hadoop@pi0 "rm -rf $HADOOP_HOME/tmp"
ssh hadoop@pi0 "rm -rf $HADOOP_HOME/pids"

ssh hadoop@pi1 "rm -rf ~/hadoop-data"
ssh hadoop@pi1 "rm -rf $HADOOP_HOME/tmp"
ssh hadoop@pi1 "rm -rf $HADOOP_HOME/pids"
