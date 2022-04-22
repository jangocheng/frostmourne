package com.autohome.frostmourne.monitor.service.core.metric.elasticsearch;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autohome.frostmourne.monitor.model.contract.MetricContract;
import com.autohome.frostmourne.monitor.service.core.domain.MetricData;
import com.autohome.frostmourne.monitor.service.core.metric.AbstractNumericMetric;
import com.autohome.frostmourne.monitor.service.core.query.IElasticsearchDataQuery;

public class ElasticsearchNumericMetric extends AbstractNumericMetric {
    @Resource
    private IElasticsearchDataQuery elasticsearchDataQuery;

    @Override
    public MetricData pullMetricData(DateTime start, DateTime end, MetricContract metricContract,
        Map<String, String> ruleSettings) {
        try {
            return elasticsearchDataQuery.queryElasticsearchMetricValue(start, end, metricContract);
        } catch (IOException ex) {
            throw new RuntimeException("error when pullMetricData", ex);
        }
    }
}
