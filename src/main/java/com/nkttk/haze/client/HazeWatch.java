package com.nkttk.haze.client;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.model.*;
import com.amazonaws.services.cloudwatch.waiters.AmazonCloudWatchWaiters;

/**
 *
 */
public class HazeWatch implements AmazonCloudWatch {

    @Override
    public void setEndpoint(String endpoint) {

    }

    @Override
    public void setRegion(Region region) {

    }

    @Override
    public DeleteAlarmsResult deleteAlarms(DeleteAlarmsRequest deleteAlarmsRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public DescribeAlarmHistoryResult describeAlarmHistory(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public DescribeAlarmHistoryResult describeAlarmHistory() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public DescribeAlarmsResult describeAlarms(DescribeAlarmsRequest describeAlarmsRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public DescribeAlarmsResult describeAlarms() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public DescribeAlarmsForMetricResult describeAlarmsForMetric(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public DisableAlarmActionsResult disableAlarmActions(DisableAlarmActionsRequest disableAlarmActionsRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public EnableAlarmActionsResult enableAlarmActions(EnableAlarmActionsRequest enableAlarmActionsRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest getMetricStatisticsRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public ListMetricsResult listMetrics(ListMetricsRequest listMetricsRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public ListMetricsResult listMetrics() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public PutMetricAlarmResult putMetricAlarm(PutMetricAlarmRequest putMetricAlarmRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public PutMetricDataResult putMetricData(PutMetricDataRequest putMetricDataRequest) {
        return new PutMetricDataResult();
    }

    @Override
    public SetAlarmStateResult setAlarmState(SetAlarmStateRequest setAlarmStateRequest) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public void shutdown() {

    }

    @Override
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public AmazonCloudWatchWaiters waiters() {
        throw new RuntimeException("NOT IMPLEMENTED");
    }
}
