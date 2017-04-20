/**
 *
 * Copyright (c) 2014, the Railo Company Ltd. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either 
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with this library.  If not, see <http://www.gnu.org/licenses/>.
 * 
 **/
package lucee.runtime.cache.tag.query;

import lucee.commons.digest.HashUtil;
import lucee.runtime.cache.tag.udf.UDFArgConverter;
import lucee.runtime.type.Query;
import lucee.runtime.type.query.QueryResult;

public class QueryCacheItem extends QueryResultCacheItem {

	private static final long serialVersionUID = 7327671003736543783L;

	public final Query query;

	public QueryCacheItem(Query query, String[] tags){
		super((QueryResult)query,tags);
		this.query=query;
	}

	@Override
	public String getHashFromValue() {
		return Long.toString(HashUtil.create64BitHash(UDFArgConverter.serialize(query)));
	}
	

	public Query getQuery() {
		return query;
	}


	@Override
	public Object duplicate(boolean deepCopy) {
		return new QueryCacheItem((Query)query.duplicate(true),getTags());
	}

}