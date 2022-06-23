import java.io.IOException;

private Configuration conf;
private CommandLine commandLine;

public GenericOptionsParser(Options opts, String[] args)
throws IOExceoption {
	this(new Configuration(), new Options(), args);
}

public GenericOptionsParser(String[] args)
throws IOException {
	this(new Configuration(), new Options(), args);
}

public GenericOptionsParser(Configuration conf, String[] args)
throws IOException {
	this(conf, new Options(), args);
}

public GenericOptionsParser(Configuration conf, Options options, String[] args)
throws IOException {
	parseGeneralOptions(Options, conf, args);
	this.conf = conf;
}
