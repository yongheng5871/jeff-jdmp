/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.jdmp.core.script.jdmp.node;

import java.util.*;
import org.jdmp.core.script.jdmp.analysis.*;

@SuppressWarnings("nls")
public final class AScript extends PScript
{
    private final LinkedList<PCommand> _commands_ = new LinkedList<PCommand>();

    public AScript()
    {
        // Constructor
    }

    public AScript(
        @SuppressWarnings("hiding") List<PCommand> _commands_)
    {
        // Constructor
        setCommands(_commands_);

    }

    @Override
    public Object clone()
    {
        return new AScript(
            cloneList(this._commands_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAScript(this);
    }

    public LinkedList<PCommand> getCommands()
    {
        return this._commands_;
    }

    public void setCommands(List<PCommand> list)
    {
        this._commands_.clear();
        this._commands_.addAll(list);
        for(PCommand e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._commands_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._commands_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PCommand> i = this._commands_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PCommand) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
