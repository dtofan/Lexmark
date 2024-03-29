/*grails
{
	mongo
	{
		host = "ds037587.mongolab.com"
		port = 37587
		username = "admin"
		password = "monster11"
		databaseName = "twistage"
	}
}*/

/*dataSource
{
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	properties
	{
		maxActive = 20
		maxIdle = 10
		minIdle = 5
		initialSize = 5
		minEvictableIdleTimeMillis = 1800000
		timeBetweenEvictionRunsMillis = 1800000
		maxWait = 10000
	}
}

hibernate
{
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
	//show_sql=true
}

// environment specific settings
environments {
	development {
		dataSource {

			dbCreate = "update"
			url = "jdbc:mysql://localhost/twistage?autoReconnect=true"
			username = "root"
			password = "lsptest"
		}
	}
	test {
		dataSource {
			driverClassName = "org.h2.Driver"
			username = "sa"
			password = ""
			dbCreate = "create-drop"
			url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
		}
	}
	production {
		dataSource {

			dbCreate = "update"
			url = "jdbc:mysql://localhost/twistage?autoReconnect=true"
			username = "root"
			password = "lsptest"
		}
	}
}*/


/*dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
*/