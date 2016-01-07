task default: %w[dbshell]

namespace :db do
  desc "Opens psql shell"
  task :shell do
    puts "connecting to database"
  end

  desc "Initialize DB with seed data"
  task :init do
    createdb "show_checker"
    puts "initializing database"
  end
end

def createdb db_name
  puts "creating db with name " + db_name
  system "createdb #{db_name}"
end
