#include <vector>
#include <tuple>
#include <map>
#include <iostream>

using namespace std;

struct Device
{
    int deviceId;
    int deviceMem;
    Device(int deviceId, int deviceMem);
};
Device::Device(int deviceId, int deviceMem)
{
    this->deviceId=deviceId;
    this->deviceMem=deviceMem;
}

struct Proc{
    int procId;
    int procAvailableMem;
    vector<Device> deviceVec;
    Proc(int procId,int procAvailableMem,vector<Device> deviceVec);
    int insertDevice(Device device);
    bool deleteDevice(int deviceId);
};
Proc::Proc(int procId,int procAvailableMem,vector<Device> deviceVec)
{
    this->procId=procId;
    this->procAvailableMem=procAvailableMem;
    this->deviceVec=deviceVec;
}

int Proc::insertDevice(Device device)
{
    if(procAvailableMem-device.deviceMem>=0)
    {
        this->deviceVec.push_back(device);
        procAvailableMem=procAvailableMem-device.deviceMem;
        return 0;
    }
    return -1;
}

bool Proc::deleteDevice(int deviceId)
{
    for(int i=0;i<deviceVec.size();i++)
    {
        if(deviceVec[i].deviceId==deviceId)
        {
            procAvailableMem+=deviceVec[i].deviceMem;
            deviceVec.erase(deviceVec.begin()+i);
            return true;
        }
    }
    return false;
}

struct ProcGroup{
    int procGroupId;
    vector<Proc> procs;
    ProcGroup(int procGroupId,vector<Proc> procs);
};
ProcGroup::ProcGroup(int procGroupId,vector<Proc> procs)
{
    this->procGroupId=procGroupId;
    this->procs=procs;
}


class DeviceMgtSystem{
private:
    const int MAX_DEVICE_TYPE = 3;
    vector<ProcGroup> procGroups;
public:
    DeviceMgtSystem(int procNum, int maxMemSize)
    {
        for(int i=0;i<MAX_DEVICE_TYPE; i++)
        {
            vector<Proc> tempProcVecs;
            for(int j=0;j<procNum;j++)
            {
                vector<Device> tempDeviceVec;
                tempProcVecs.push_back(Proc(j,maxMemSize, tempDeviceVec));
            }
            ProcGroup tempProcGroup(i+1,tempProcVecs);
            procGroups.push_back(tempProcGroup);
        }
    }

    int createDevice(int deviceId, int deviceType, int memSize)
    {
        int availProcIndex;
        int availMem=0;
        int procGroupId=deviceType-1;
        for(int j=0; j<procGroups[procGroupId].procs.size(); j++)
        {
            if(procGroups[procGroupId].procs[j].procAvailableMem>availMem)
            {
                availMem=procGroups[procGroupId].procs[j].procAvailableMem;
                availProcIndex=j;
                continue;
            }
            if(procGroups[procGroupId].procs[j].procAvailableMem==availMem)
            {
                if(procGroups[procGroupId].procs[j].procId<procGroups[procGroupId].procs[availProcIndex].procId)
                {
                    availMem=procGroups[procGroupId].procs[j].procAvailableMem;
                    availProcIndex=j;
                    continue;
                }
            }
        }
        Device device(deviceId,memSize);
        int errCode=procGroups[procGroupId].procs[availProcIndex].insertDevice(device);
        if(errCode!=-1)
        {
            return procGroups[procGroupId].procs[availProcIndex].procId;
        }
        return -1;
    }

    bool deleteDevice(int deviceId)
    {
        for(int i=0;i<MAX_DEVICE_TYPE;i++)
        {
            for(int j=0;j<procGroups[i].procs.size();j++)
            {
                for(int k=0;k<procGroups[i].procs[j].deviceVec.size();k++)
                {
                    if(procGroups[i].procs[j].deviceVec[k].deviceId==deviceId)
                    {
                        return procGroups[i].procs[j].deleteDevice(deviceId);
                    }
                }
            }
        }
        return false;
    }

    vector<tuple<int, int, int>> queryDevice(int deviceType)
    {
        vector<tuple<int, int, int>> result;
        int proGroupId=deviceType-1;
        for(int i=0;i<procGroups[proGroupId].procs.size();i++)
        {
            for(int j=0;j<procGroups[proGroupId].procs[i].deviceVec.size();j++)
            {
                int deviceId=procGroups[proGroupId].procs[i].deviceVec[j].deviceId;
                int memSize=procGroups[proGroupId].procs[i].deviceVec[j].deviceMem;
                int procId=procGroups[proGroupId].procs[i].procId;
                result.push_back(make_tuple(deviceId,memSize,procId));
            }
        }

        for(int i=0;i<result.size();i++)
        {
            for(int j=i+1;j<result.size();j++)
            {
                if(get<1>(result[i])<get<1>(result[j]))
                {
                    swap(result[i],result[j]);
                    continue;
                }
                if(get<1>(result[i])==get<1>(result[j]))
                {
                    if(get<2>(result[i])>get<2>(result[j]))
                    {
                        swap(result[i],result[j]);
                        continue;
                    }
                    if(get<2>(result[i])==get<2>(result[j]))
                    {
                        if(get<2>(result[i])==get<2>(result[j]))
                        {
                            swap(result[i],result[j]);
                            continue;
                        }
                        
                    }
                }
            }
        }
        return result;
    }
};


void printVec(vector<tuple<int, int, int>> input)
{
    if(input.empty())
    {
        cout<<"[[]]"<<endl;
        return;
    }
    for(auto it = input.begin(); it != input.end(); it++)
    {
        cout<<get<0>(*it)<<" "<<get<1>(*it)<<" "<<get<2>(*it)<<endl;
    }
}

int main()
{
    cout<<"============TestCase 1============"<<endl;
    DeviceMgtSystem dms1(2, 200);
    cout<<dms1.createDevice(8,1,50)<<endl;
    cout<<dms1.createDevice(12,1,30)<<endl;
    cout<<dms1.createDevice(3,1,30)<<endl;
    vector<tuple<int, int, int>> dms1VecResult1 = dms1.queryDevice(1);
    printVec(dms1VecResult1);
    cout<<dms1.createDevice(15,1,30)<<endl;
    vector<tuple<int, int, int>> dms1VecResult2 = dms1.queryDevice(1);
    printVec(dms1VecResult2);
    cout<<dms1.deleteDevice(10)<<endl;
    cout<<endl;


    cout<<"============TestCase 2============"<<endl;
    DeviceMgtSystem dms2(2, 100);
    cout<<dms2.createDevice(18,2,50)<<endl;
    cout<<dms2.createDevice(3,2,30)<<endl;
    cout<<dms2.createDevice(12,2,20)<<endl;
    vector<tuple<int, int, int>> dms2VecResult1 = dms2.queryDevice(1);
    printVec(dms2VecResult1);
    vector<tuple<int, int, int>> dms2VecResult2 = dms2.queryDevice(2);
    printVec(dms2VecResult2);
    cout<<dms2.createDevice(15,1,40)<<endl;
    cout<<dms2.createDevice(6,2,30)<<endl;
    cout<<dms2.createDevice(19,2,60)<<endl;
    cout<<dms2.deleteDevice(18)<<endl;
    cout<<dms2.createDevice(26,2,70)<<endl;
    vector<tuple<int, int, int>> dms2VecResult3 = dms2.queryDevice(1);
    printVec(dms2VecResult3);
    vector<tuple<int, int, int>> dms2VecResult4 = dms2.queryDevice(2);
    printVec(dms2VecResult4);
    cout<<endl;
}
